class Solution {

    int overAllMax = Integer.MIN_VALUE;
    public void calculateLIS(int [] nums, int currIdx, int prevIdx, int count){
        // Join or Not Join 
        if(currIdx == nums.length){
            overAllMax = Math.max(overAllMax, count);
            return;
        }
        if(prevIdx == -1 || ( prevIdx >= 0 && nums[prevIdx] < nums[currIdx])){
            calculateLIS(nums, currIdx + 1, currIdx, count + 1);
        }
        calculateLIS(nums, currIdx + 1, prevIdx, count);
    }
    public int lengthOfLIS(int[] nums) {
        calculateLIS(nums, 0, -1, 0);
        return overAllMax;
    }
}
