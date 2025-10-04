import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        boundaryTraversal(m, n, matrix);
        sc.close();
    }

    public static void boundaryTraversal(int n, int m, int[][] mat) {

       int tbe = 0;
       if(n == 1){
        tbe = m;
       }else if(m == 1){
        tbe = n;
       }else{
        tbe = 2*(n + m) - 4;
       }
       int minRow = 0;
       int maxRow = n - 1;
       int minCol = 0;
       int maxCol = m - 1;
       int count = 0;
       // Print top layer or first row 
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
    }
}
