import java.util.*;

public class Main {
    public static int[] SelectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < minVal){
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            // Swap value present at ith index with the minimumVal index 

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        return arr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = SelectionSort(arr);

        for(int a : ans)
            System.out.print(a + " ");
    }
}
