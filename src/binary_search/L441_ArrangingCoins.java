package binary_search;

// leetcode 441: link: https://leetcode.cn/problems/arranging-coins/
public class L441_ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) <= 2L * n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
