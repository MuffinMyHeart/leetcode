package binary_search;

// leetcode 1292   link: https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
public class L1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public static void main(String[] args) {
        int[][] mat = {{18,70},{61,1},{25,85},{14,40}};
        System.out.println(maxSideLength(mat, 40184));
    }

    public static int maxSideLength(int[][] mat, int threshold) {
       return sarriaAnswer(mat, threshold);
    }

    // this is bad method , to be optimized.
    private static int sarriaAnswer(int[][] mat, int threshold) {
        int l = 0;
        int r = Math.min(mat.length, mat[0].length);
        int[][] p = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 1; i < p.length; i++) {
            int sum = 0;
            for (int j = 1; j < p[0].length; j++) {
                sum += mat[i - 1][j - 1];
                p[i][j] = p[i - 1][j] + sum;
            }
        }
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(p, mid, threshold)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private static boolean check(int[][] p, int target, int threshold) {
        if (target == 0) return false;
        for (int i = 1; i <= p.length - target; i++) {
            for (int j = 1; j <= p[0].length - target; j++) {
                int sum = p[i + target - 1][j + target - 1] - p[i + target - 1][j - 1] - p[i - 1][j + target - 1] + p[i - 1][j - 1];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
