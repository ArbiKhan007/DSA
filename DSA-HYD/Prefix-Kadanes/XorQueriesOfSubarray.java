class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] preXor = new int[arr.length];
        preXor[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            preXor[i] = preXor[i-1]^arr[i];
        }
        int [] ans = new int[queries.length];
        int i = 0;
        for(int [] query : queries){
            int left = query[0];
            int right = query[1];
            int leftXor = left - 1 >= 0 ? preXor[left - 1] : 0;
            int rightXor = preXor[right];
            int xor = leftXor^rightXor;
            ans[i] = xor;
            i++;
        }
        return ans;
    }
}
