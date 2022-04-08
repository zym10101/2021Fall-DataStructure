public class 分治法求最大子序列和 {
    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right)
            return Math.max(a[left], 0);
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        int temp=Math.max(maxLeftSum, maxRightSum);
        return Math.max(temp, maxLeftBorderSum + maxRightBorderSum);
    }

    public static void maxSubSum3(int[] a) {
        maxSumRec(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        maxSubSum3(new int[]{4, -3, 5, -2, -1, 2, 6, -2});
    }
}
