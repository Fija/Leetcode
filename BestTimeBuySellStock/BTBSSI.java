class Solution {
    int maxProfit(int[] prices) {
        int max = 0;
        int min = 0;
        int i;
        int len = prices.length;
        for (i = 0; i < len; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            }else if (prices[i] - prices[min] > max) {
                max = prices[i] - prices[min];
            }
        }
        return max;
    }
}
public class BTBSSI {
    public static void main(String[] args) {
        //int[] A = {9,10,2,4,7,1,3};
        int[] A = {9,16,2,4,7,1,3};
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(A));
    }
}

