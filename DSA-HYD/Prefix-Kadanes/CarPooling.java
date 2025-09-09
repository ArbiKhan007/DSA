class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
         int [] path = new int[1001];

         for(int [] trip : trips){
            int numP = trip[0];
            int st = trip[1];
            int en = trip[2];
            path[st] += numP;
            path[en] -= numP;
         }

         if(path[0] > capacity){
            return false;
         }

         for(int i = 1; i < path.length; i++){
            path[i] = path[i] + path[i - 1];
            if(path[i] > capacity){
                return false;
            }
         }

         return true;
    }
}
