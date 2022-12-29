package binary_search;

// leetcode 410  link: https://leetcode.cn/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int result = splitArray(nums, 2);
        System.out.println(result);
    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > left) {
                left = num;
            }
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hasValidSubarry(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean hasValidSubarry(int[] nums, int target, int maxSize) {
        int sum = 0;
        int currentSize = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                currentSize ++;
                sum = nums[i];
            }
        }
        return currentSize <= maxSize;
    }
}
