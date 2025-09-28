import java.util.*;

class Solution {
    public void printElements(int[][] arr , int n  , int m) {
       int tRows = arr.length;
       int tCols = arr[0].length;
       for(int row = 0; row < tRows; row++){
        for(int col = 0; col < tCols; col++){
            System.out.print(arr[row][col] + " ");
        }
        System.out.println();
       }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.printElements(arr , n , m);
        sc.close();
    }
}
