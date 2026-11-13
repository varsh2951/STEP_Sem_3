package Week_11.Practice;

import java.util.Arrays;

public class RemoveDuplicatesInPlace {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIdx]) {
                uniqueIdx++;
                nums[uniqueIdx] = nums[i];
            }
        }
        return uniqueIdx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);

        System.out.println("length = " + len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, len)));
    }
}