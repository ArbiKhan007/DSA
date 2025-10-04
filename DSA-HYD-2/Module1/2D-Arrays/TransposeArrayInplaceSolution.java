import java.util.*;
import java.io.*;

class Solution {
    public int[][] matrixTranspose(int[][] mat, int n) {
        int tRows = mat.length;
        int tCols = mat[0].length;
        for(int d = 1; d < tCols; d++){
            int i = 0;
            int j = d;
            while(j < mat[0].length){
                int val = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = val; 
                i++;
                j++;
            }
        }
        return mat;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        Solution Obj = new Solution();
        int[][] ans = Obj.matrixTranspose(matrix, n);
        for(int i=0; i<n; i++)
        {   for(int j=0; j<n; j++)
                  {
                       System.out.print(ans[i][j] + " ");
                  } System.out.println("");
        }
        sc.close();
    }
}
