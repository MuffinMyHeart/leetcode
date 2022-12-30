package binary_search;

// leetcode 162 link: https://leetcode.cn/problems/find-peak-element/description/
public class L162_FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] arr) {
        return sarriaAnswer(arr);
    }

    private static int sarriaAnswer(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
