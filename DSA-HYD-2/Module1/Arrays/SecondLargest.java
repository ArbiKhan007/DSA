import java.io.*;
import java.util.*;


public class Main {
    public static void SecondLargest(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                smax = max;
                max = arr[i];
            }else if(arr[i] > smax){
                smax = arr[i];
            }
        }
        System.out.println(smax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] arr= new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
    
        SecondLargest(arr,n);
    }
}
