package tow_point;

import java.util.Arrays;

// leetcode 80 link: https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//        Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//        Return k after placing the final result in the first k slots of nums.
//
//        Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
public class L80_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = { 1,1,1,2,2,3 };
        int index = removeDuplicates(nums);
        System.out.println(index);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
       int length = nums.length;
       if (length <= 2) return 2;
       int left = 2;
       int right = 2;
       while (right < length) {
           if (nums[left - 2] != nums[right]) {
               nums[left] = nums[right];
               left++;
           }
           right++;
       }
       return left;
    }
}
