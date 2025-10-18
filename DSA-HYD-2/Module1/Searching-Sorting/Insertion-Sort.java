import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        
        insertionSort(array,n);

		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
    }
	
	static void insertionSort(int [] arr, int n)
    {
        for(int i = 1; i < arr.length; i++){
			int j = i; // We need to set j at the ith element index 
			while(j > 0 && arr[j] < arr[j - 1]){
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
    }
}
