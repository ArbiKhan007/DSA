import java.util.*;

public class Main {
    static int maximum_occurrence(int arr[], int n) {
        Arrays.sort(arr);
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqNum = -1;
        int i = 0;
        int j = 0;

        while(j < arr.length){
            if(arr[i] == arr[j]){
                j++;
            }else{
                int count = j - i;
                if(count > maxFreq){
                    maxFreq = count;
                    maxFreqNum = arr[i];
                }
                i = j;
            }
        }
        
        int count = j - i;
        if(count > maxFreq){
            maxFreq = count;
            maxFreqNum = arr[i];
        }

        return maxFreqNum;


         
    }
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(maximum_occurrence(arr, n));

    }
}
