package tow_point;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        int index = removeDuplicates(nums);
        System.out.println(index);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[left - 1] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
