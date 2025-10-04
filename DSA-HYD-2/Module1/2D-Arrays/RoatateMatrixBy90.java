import java.io.*;
import java.util.*;

class Solution {
    public void matrixTranspose(int[][] mat) {
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
    }

    public int[][] rotateBy90(int [][]mat) {
        matrixTranspose(mat);
        for(int row = 0; row < mat.length; row++){

            // Approach 1 
            // int [] arr = mat[row];
            // int st = 0;
            // int en = arr.length - 1;
            // while(st < en){
            //     int temp = arr[st];
            //     arr[st] = arr[en];
            //     arr[en] = temp;
            //     st++;
            //     en--;
            // }
            // Approach 2
            int st = 0;
            int en = mat[0].length - 1;
            while(st < en){
                int temp = mat[row][st];
                mat[row][st] = mat[row][en];
                mat[row][en] = temp;
                st++;
                en--;
            }
        }

        return mat;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                mat[i][j]=sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        int[][] ans = Obj.rotateBy90(mat);
        for(int i=0; i<n; i++)
        {   for(int j=0; j<n; j++)
                  {
                       System.out.print(ans[i][j] + " ");
                  } System.out.println("");
        }
        System.out.println('\n');
    }
}
