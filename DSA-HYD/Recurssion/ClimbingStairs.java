class Solution {
    public int climbStairs(int n) {
        return calculateTotalWays(n, new Integer[n + 1]);
    }

    public int calculateTotalWays(int n, Integer [] dp){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(dp[n] != null){
            return dp[n];
        }
       int w1 =  calculateTotalWays(n - 1, dp);
       int w2 =  calculateTotalWays(n - 2, dp);
       dp[n] = w1 + w2;
       return w1 + w2;
    }

}
