import java.util.ArrayList;
import java.util.List;

public class LinearSearchExperiment {
    public static int linearSearch(int[] arr, int key) {
        int comparisons = 0;
        for (int value : arr) {
            comparisons++;
            if (value == key) {
                return comparisons;
            }
        }
        return comparisons;
    }

    public static void performExperiments() {
        List<Integer> sizes = new ArrayList<>();
        List<Integer> minComparisons = new ArrayList<>();
        List<Integer> maxComparisons = new ArrayList<>();
        List<Double> avgComparisons = new ArrayList<>();
        
        for (int n = 10; n <= 100; n += 5) {
            sizes.add(n);
            List<Integer> comparisonsList = new ArrayList<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            // n successful searches
            for (int key : arr) {
                comparisonsList.add(linearSearch(arr, key));
            }

            // 1 unsuccessful search
            comparisonsList.add(linearSearch(arr, -1)); // key -1 is not in the list

            minComparisons.add(comparisonsList.stream().min(Integer::compare).orElse(0));
            maxComparisons.add(comparisonsList.stream().max(Integer::compare).orElse(0));
            avgComparisons.add(comparisonsList.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        }

        plotGraph(sizes, minComparisons, maxComparisons, avgComparisons);
    }

    public static void plotGraph(List<Integer> sizes, List<Integer> minComparisons, 
                                 List<Integer> maxComparisons, List<Double> avgComparisons) {
        System.out.println("Size\tMin Comparisons\tMax Comparisons\tAvg Comparisons");
        for (int i = 0; i < sizes.size(); i++) {
            System.out.printf("%d\t%d\t\t\t%d\t\t\t%.2f\n", 
                              sizes.get(i), minComparisons.get(i), 
                              maxComparisons.get(i), avgComparisons.get(i));
        }
    }

    public static void main(String[] args) {
        performExperiments();
    }
}
