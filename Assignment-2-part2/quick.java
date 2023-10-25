import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class quick {
    public static void sort(Comparable[] arr) {
        shuffle(arr); // Shuffle array to guarantee performance
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(arr, low, high);
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }

    private static int partition(Comparable[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable pivot = arr[low];
        while (true) {
            while (less(arr[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (less(pivot, arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(arr, i, j);
        }
        exchange(arr, low, j);
        return j;
    }

    private static void shuffle(Comparable[] arr) {
        List<Comparable> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
