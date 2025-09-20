import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int [] arr = new int[n];
       for(int i = 0; i < n; i++){
         arr[i] = scn.nextInt();
       }
       doAllOperations(arr);
    }

    public static int [] calculateSumAndMax(int [] arr){
        int sum = 0;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }
        int [] ans = new int[2];
        ans[0] = sum;
        ans[1] = max;
        return ans;
    }

    public static void doAllOperations(int [] array){
        // 1. Calculate Sum, Calculate Avg, Calculate 
        // 2. Print it in the single line 
        int [] sumMax = calculateSumAndMax(array);
        int sum = sumMax[0];
        int avg = sum/array.length;
        int max = sumMax[1];
        System.out.println(sum + " " + avg + " " + max);
    }

}
