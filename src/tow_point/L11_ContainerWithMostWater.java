package tow_point;
//        leetcode 11: link: https://leetcode.cn/problems/container-with-most-water/
//        You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//        Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//        Return the maximum amount of water a container can store.
//
//        Notice that you may not slant the container.

public class L11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length -1;
        int maxArea = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                int area = height[i] * (j - i);
                if (area > maxArea) maxArea = area;
                i++;
            } else  {
                int area = height[j] * (j - i);
                if (area > maxArea) maxArea = area;
                j--;
            }
        }
        return maxArea;
    }
}
