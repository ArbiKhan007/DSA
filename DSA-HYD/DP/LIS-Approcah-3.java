class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int lo = 0;
            int hi = ans;
            while(lo < hi){
                int mid = lo + (hi - lo)/2;
                if(dp[mid] < nums[i]){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            dp[lo] = nums[i];
            if(lo == ans){
                ans++;
            }
        }

        return ans;
    }
}
