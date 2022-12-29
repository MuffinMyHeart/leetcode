package binary_search;

// leetcode 153 link: https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
public class L153_FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {13,15,17,11};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                if (nums[left] < minValue) {
                    minValue = nums[left];
                }
                left = mid + 1;
            } else {
                if (nums[mid] < minValue) {
                    minValue = nums[mid];
                }
                right = mid - 1;
            }
        }
        return minValue;
    }
}
