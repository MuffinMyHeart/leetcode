package tow_point;
// leetcode 42 link: https://leetcode.cn/problems/trapping-rain-water/
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
public class L42_TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while (left <= right) {
            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];
            if (height[left] < height[right]) {
                int thisTime = leftMax - height[left];
                if (thisTime > 0) total += thisTime;
                left++;
            } else {
                int thisTime = rightMax - height[right];
                if (thisTime > 0) total += thisTime;
                right--;
            }
        }
        return total;
    }
}
