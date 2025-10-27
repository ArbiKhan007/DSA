class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int overAllMax = 0;
        for(int i = 0; i < nums.length; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            overAllMax = Math.max(overAllMax, dp[i]);
        }

        return overAllMax;
    }
}
