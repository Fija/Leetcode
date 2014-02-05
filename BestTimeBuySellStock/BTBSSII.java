class Solution {
    int maxProfit(int[] prices) {
        int i;
        int low = 0;
        int profit=0;
        int len = prices.length;
        if (len <= 1) return 0;
        //if (prices[0] < prices[1]) low = 0;
        for (i = 1; i < len-1; i++) {
            if (prices[i] <= prices[i-1] && prices[i] <= prices[i+1]) {
                low = i;
            }else if (prices[i] > prices[i-1] && prices[i] >= prices[i+1]) {
                profit = profit + prices[i]-prices[low];
            }
        }
        if (prices[len-2] < prices[len-1]) {
            profit = profit + prices[len-1]-prices[low];
        }
        return profit;
    }
}
public class BTBSSII {
    public static void main(String[] args) {
        int[] A = {19,16,16,2,2,4,4,7,7,1,3,4};
        int[] B = {1,0,-1,5};
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(A));
    }
}
