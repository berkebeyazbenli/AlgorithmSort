import java.util.Arrays;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        int[] sizes = {250, 1000, 4000, 16000, 64000}; // array sizes to test with
        String[] sortAlgorithms = {"Merge", "Quick", "Selection", "Insertion", "noSort"}; // sorting algorithms to test with
        Random rand = new Random();
        for (int size : sizes) {
            Integer[] arrAsc = new Integer[size];
            Integer[] arrDesc = new Integer[size];
            Integer[] arrRand = new Integer[size];
            for (int i = 0; i < size; i++) {
                arrAsc[i] = i;
                arrDesc[i] = size - i;
                arrRand[i] = rand.nextInt(size);
            }
            
            for (String sortAlgorithm : sortAlgorithms) {
                long totalTime = 0;
                int numRuns = 10;
                for (int i = 0; i < numRuns; i++) {
                    Integer[] arrCopy = null;
                    if (sortAlgorithm.equalsIgnoreCase("noSort")) {
                        arrCopy = Arrays.copyOf(arrRand, arrRand.length);
                    } else if (sortAlgorithm.equalsIgnoreCase("Merge")) {
                        arrCopy = Arrays.copyOf(arrAsc, arrAsc.length);
                    } else if (sortAlgorithm.equalsIgnoreCase("Quick")) {
                        arrCopy = Arrays.copyOf(arrAsc, arrAsc.length);
                    } else if (sortAlgorithm.equalsIgnoreCase("Selection")) {
                        arrCopy = Arrays.copyOf(arrAsc, arrAsc.length);
                    } else if (sortAlgorithm.equalsIgnoreCase("Insertion")) {
                        arrCopy = Arrays.copyOf(arrAsc, arrAsc.length);
                    }
                    long startTime = System.currentTimeMillis();
                    main.sortDiff(arrCopy, sortAlgorithm);
                    long endTime = System.currentTimeMillis();
                    totalTime += endTime - startTime;
                }
                long medianTime = totalTime / numRuns;
                System.out.println(sortAlgorithm + " on size " + size + ": " + medianTime + "ms");
            }
        }
}
}