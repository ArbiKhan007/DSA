class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int pMax = 1;
        int sMax = 1;
        for(int i = 0; i < nums.length; i++){
            pMax *= nums[i];
            sMax *= nums[n - i - 1];
            max = Math.max(max, Math.max(pMax, sMax));
            if(nums[i] == 0){
                pMax = 1;
            }
            if(nums[n - i - 1] == 0){
                sMax = 1;
            }
        }

        return max;
    }
}
