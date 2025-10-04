import java.util.*;
import java.io.*;

class Solution {
    public int[][] matrixTranspose(int[][] mat, int n) {
        int tRows = mat.length;
        int tCols = mat[0].length;
        int [][] tArr = new int[tRows][tCols];
        for(int row = 0; row < tRows; row++){
            for(int col = 0; col < tCols; col++){
            //    int val = mat[row][col];
            //    int tr = col;
            //    int tc = row;
            //    tArr[tr][tc] = val;
            tArr[col][row] = mat[row][col];
            }
        }
        return tArr;
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
