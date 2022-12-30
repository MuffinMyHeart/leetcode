package binary_search;

// leetcode 1011 link: https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
public class L1011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        return sarriaAnswer(weights, days);
    }

    private static int sarriaAnswer(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            if (weights[i] > low) {
                low = weights[i];
            }
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShipInDays(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canShipInDays(int[] weights, int targetWeight, int days) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > targetWeight) {
                sum = weights[i];
                count ++;
            }
        }
        return count <= days;
    }


}
