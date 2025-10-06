class Solution {
    public static int minCost(int[] arr) {
        
        if(arr.length == 0 || arr.length == 1){
            return 0;
        }
        
        // logK -> K is equals to size of the array 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Nlogn
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        
        
        // Removing -> logk
        int overAllCost = 0;
        while(pq.size() >= 2){
            int fs = pq.remove();
            int ss = pq.remove();
            int cost = fs + ss;
            overAllCost += cost;
            pq.add(cost);
        }
        
        return overAllCost;
        
        
        
    }
}
