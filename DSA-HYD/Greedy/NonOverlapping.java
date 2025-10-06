class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int [] py = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            int [] curr = intervals[i];
            int pyst = py[0];
            int pyen = py[1];
            int currsn = curr[0];
            int curren = curr[1];
            if(pyen > currsn){
                if(pyen > curren){
                   py = curr;
                }
                count++;
            }else{
                py = curr;
            }
        }
        return count;
    }
}
