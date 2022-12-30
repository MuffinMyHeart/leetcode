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
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(mat, mid, threshold)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private static boolean check(int[][] mat, int target, int threshold) {
        if (target == 0) return false;
        for (int i = 0; i <= mat.length - target; i++) {
            for (int j = 0; j <= mat[0].length - target; j++) {
                if (checkSum(mat, target, i, j, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkSum(int[][] mat, int target, int iStart, int jStart, int threshold) {
        int sum = 0;
        for (int i = iStart; i < iStart + target; i++) {
            for (int j = jStart; j < jStart + target; j++) {
                sum += mat[i][j];
            }
        }
        return sum <= threshold;
    }
}
