package tow_point;

import java.util.Arrays;

// leetcode 283 link: https://leetcode.cn/problems/move-zeroes/
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//        Note that you must do this in-place without making a copy of the array.
public class L283_MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
//        int[] nums = {1};
//        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        // find first left index that it's value not equals 0;
        while (left < nums.length && nums[left] != 0) left++;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
                nums[right] = 0;
            }
            right++;
        }
    }
}
