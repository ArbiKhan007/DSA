class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int [] nslArr = new int[arr.length];
        int [] nsrArr = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nslArr[i] = -1;
            }else{
                nslArr[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nsrArr[i] = arr.length;
            }else{
                nsrArr[i] = st.peek();
            }
            st.push(i);
        }

        //2 

        // [71, 55] ,[71, 55, 82], [71, 55, 82, ] [55], [55, 82], [55, 82, 55]

        long sum = 0;

        for(int i = 0; i < arr.length; i++){
            int leftCount = i - nslArr[i];
            int rightCount = nsrArr[i] - i;
            long count = (leftCount*rightCount);
           
            sum = (sum + (count*arr[i])%mod)%mod;
            //System.out.println(leftCount + " : " + rightCount + " : " + count + " : " + count*arr[i]);
        }

        return (int)sum;


    }
}
