package binary_search;

// leetcode 852  link: https://leetcode.cn/problems/peak-index-in-a-mountain-array/
public class L852_PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        return sarriaAnswer(arr);
    }

    private static int sarriaAnswer(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] &&  arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
