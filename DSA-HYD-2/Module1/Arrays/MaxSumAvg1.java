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

    public static int calculateMax(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int calculateSum(int [] arr){
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static void doAllOperations(int [] array){
        // 1. Calculate Sum, Calculate Avg, Calculate 
        // 2. Print it in the single line 
        int sum = calculateSum(array);
        int avg = sum/array.length;
        int max = calculateMax(array);
        System.out.println(sum + " " + avg + " " + max);
    }

}
