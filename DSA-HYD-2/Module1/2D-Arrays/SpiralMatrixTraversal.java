import java.io.*;
import java.util.*;

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

        spirallyTraverse(mat);     
        System.out.println('\n');
    }

    public static void spirallyTraverse(int [][]mat) {
       // your code here
       int n = mat.length;
       int m = mat[0].length;
       int tbe = n*m;
       int count = 0;
       int minRow = 0;
       int maxRow = n - 1;
       int minCol = 0;
       int maxCol = m - 1;
       while(count < tbe){
        for(int j = minCol; j <= maxCol && count < tbe; j++){
                System.out.print(mat[minRow][j] + " ");
                count++;
        }
        minRow++;
        for(int i = minRow; i <= maxRow  && count < tbe; i++){
                System.out.print(mat[i][maxCol] + " ");
                count++;
        }
        maxCol--;
        for(int j = maxCol; j>= minCol  && count < tbe; j--){
                System.out.print(mat[maxRow][j] + " ");
                count++;
        }
        maxRow--;
        for(int i = maxRow; i >= minRow  && count < tbe; i--){
            System.out.print(mat[i][minCol] + " ");
            count++;
        }
        minCol++;
       }
         
     
    }
}
