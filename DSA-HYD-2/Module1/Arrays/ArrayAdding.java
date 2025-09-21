import java.util.*;

public class Main {
  static int[] calSum(int a[], int b[], int n, int m) {
	int len = Math.max(a.length, b.length);
    int [] ans = new int[len];
	int i = a.length - 1;
	int j = b.length - 1;
	int k = ans.length - 1;
	int carry = 0;
	while(k >= 0){
		int val1 = 0;
		if(i >= 0){
			val1 = a[i];
		}
		int val2 = 0;
		if(j >= 0){
			val2 = b[j];
		}
		int sum = val1 + val2 + carry;
		ans[k] = sum%10;
		carry = sum/10;
		i--;
		j--;
		k--;
	}
	if(carry == 0){
		return ans;
	}
	int [] narr = new int[len + 1];
	narr[0] = 1;
	for(int x = 0; x < ans.length; x++){
		narr[x + 1] = ans[x];
	}
	return narr;
  }

  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
	int n1 = scn.nextInt();
	int [] arr1 = new int[n1];
	for(int i = 0; i < n1; i++){
		arr1[i] = scn.nextInt();
	}
	int n2 = scn.nextInt();
	int [] arr2 = new int[n2];
	for(int i = 0; i < n2; i++){
		arr2[i] = scn.nextInt();
	}
	int [] ans = calSum(arr1, arr2, n1, n2);
	for(int i = 0; i < ans.length; i++){
		System.out.println(ans[i]);
	}
  }
}
