// Programming Assignment:

// ● Implement Linear Search
// ○ Count the number of key comparisons for various inputs and plot the
// graph.
// ○ For every input size n , run it with n+ 1 different keys - n successful plus 1
// unsuccessful
// ○ Compute the minimum, maximum and average of the number of key
// comparisons for each input size.
// ○ Plot the graph for each case - best, worst and average number of
// comparisons.
// ○ n varies from 10 to 100 in steps of 5

import java.util.Random;

public class LinearSearchAnalysis {
    
    public static void main(String[] args) {
        Random random = new Random();

        System.out.printf("%-10s%-15s%-15s%-15s%n", "Input Size", "Min Comparisons", "Max Comparisons", "Avg Comparisons");
        
        for (int n = 10; n <= 100; n += 5) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = random.nextInt(1000);  // Random values for the array
            }

            int successfulComparisonsSum = 0;
            int unsuccessfulComparisons = 0;
            int minComparisons = Integer.MAX_VALUE;
            int maxComparisons = Integer.MIN_VALUE;

            // Successful searches
            for (int i = 0; i < n; i++) {
                int key = array[i];
                int comparisons = linearSearch(array, key);
                successfulComparisonsSum += comparisons;
                minComparisons = Math.min(minComparisons, comparisons);
                maxComparisons = Math.max(maxComparisons, comparisons);
            }

            // Unsuccessful search
            int unsuccessfulKey = 1001; // Assuming values are between 0 and 1000
            unsuccessfulComparisons = linearSearch(array, unsuccessfulKey);
            minComparisons = Math.min(minComparisons, unsuccessfulComparisons);
            maxComparisons = Math.max(maxComparisons, unsuccessfulComparisons);

            int totalComparisons = successfulComparisonsSum + unsuccessfulComparisons;
            int avgComparisons = totalComparisons / (n + 1);

            System.out.printf("%-10d%-15d%-15d%-15d%n", n, minComparisons, maxComparisons, avgComparisons);
        }
    }

    private static int linearSearch(int[] array, int key) {
        int comparisons = 0;
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if (array[i] == key) {
                return comparisons;
            }
        }
        return comparisons;  // If key is not found
    }
}
   

   
    
