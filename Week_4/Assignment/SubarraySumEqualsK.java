package Week_4.Assignment;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: prefix sum of 0 has occurred once (before starting array traversal)
        prefixSumMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - k) exists in prefix map
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println("Subarray count (k=2): " + subarraySum(nums1, 2));

        int[] nums2 = {1, -1, 0};
        System.out.println("Subarray count (k=0): " + subarraySum(nums2, 0));
    }
}