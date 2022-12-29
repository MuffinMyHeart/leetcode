package binary_search;

// leetcode 33 link: https://leetcode.cn/problems/search-in-rotated-sorted-array/
public class L33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 1};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};
        System.out.println(search2(nums, 1));
    }

    public static int search(int[] nums, int target) {
        int reverseIndex = findReverseIndex(nums);
        int result = binarySearch(nums, 0, reverseIndex - 1, target);
        if (result != -1) return result;
        result = binarySearch(nums, reverseIndex, nums.length - 1, target);
        return result;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int findReverseIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // it means left range is sorted
            if (nums[mid] >= nums[left]) {
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
