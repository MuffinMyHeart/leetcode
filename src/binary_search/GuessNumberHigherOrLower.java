package binary_search;

// leetcode 374 link: https://leetcode.cn/problems/guess-number-higher-or-lower/
public class GuessNumberHigherOrLower {

    static int pick = 6;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) > 0) {
                l = mid + 1;
            } else if (guess(mid) < 0) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        if (guess(l) > 0) {
            return l + 1;
        } else {
            return l;
        }
    }

    public static int guess(int num) {
        return Integer.compare(pick, num);
    }
}
