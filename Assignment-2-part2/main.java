import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Sorting options:"); // Prompt user to enter sorting algorithm
        String sortAlgorithm = sc.nextLine();
        System.out.println("Enter array:"); // Prompt user to enter array of integers
        String[] input = sc.nextLine().split(" ");
        Integer[] arr = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        sortDiff(arr, sortAlgorithm);
    }
    public static void sortDiff(Integer[] arr, String sortAlgorithm) {
        int minAbsDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int minA = -1;
        int minB = -1;
        
        if (sortAlgorithm.equalsIgnoreCase("Merge")) {
            merge.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Quick")) {
            quick.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Selection")) {
            selection.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Insertion")) {
            Insertion.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("noSort")) {
            int minDiff = Integer.MAX_VALUE;
            int[] minPair = new int[2];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int diff = Math.abs(arr[i] - arr[j]);
                    if (diff < minDiff) {
                        minDiff = diff;
                        minPair[0] = arr[i];
                        minPair[1] = arr[j];
                    } else if (diff == minDiff && arr[i] + arr[j] < minPair[0] + minPair[1]) {
                        minPair[0] = arr[i];
                        minPair[1] = arr[j];
                    }
                }
            }
            System.out.println("ABS:" + minDiff + ", Min=" + minPair[1] + ", Max="
                    + minPair[0]);
            return;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            int absDiff = Math.abs(arr[i] - arr[i + 1]);
            if (absDiff < minAbsDiff) {
                minAbsDiff = absDiff;
                minSum = arr[i] + arr[i + 1];
                minA = i;
                minB = i + 1;
            } else if (absDiff == minAbsDiff) {
                int sum = arr[i] + arr[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minA = i;
                    minB = i + 1;
                }
            }
        }
        
        System.out.println("ABS:" + minAbsDiff + ", Min=" + Math.min(arr[minA], arr[minB]) + ", Max="
                + Math.max(arr[minA], arr[minB]));
    }
    
}
