package binary_search;

// leetcode 33 link: https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {3, 1};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left ++;
                right --;
                // it means left range is sorted
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
