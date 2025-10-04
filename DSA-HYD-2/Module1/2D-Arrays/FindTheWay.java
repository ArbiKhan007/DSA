import java.util.*;

public class Main {
    public static int[] findTheWay(int[][] mat) {

        // dir -> 0 (N), 1(E), 2(S), 3(W)

        int dir = 1;
        int i = 0;
        int j = 0;
        int pyr = 0;
        int pyc = 0;
        while(i >= 0 && i < mat.length && j >= 0 && j < mat[0].length){
            if(mat[i][j] == 1){
                dir++;
                dir = dir%4;
                mat[i][j] = 0;
            }
            pyr = i;
            pyc = j;
            if(dir == 0){
                i--;
            }else if(dir == 1){
                j++;
            }else if(dir == 2){
                i++;
            }else{
                j--;
            }  
        }

        int [] arr = {pyr, pyc};
        return arr;

        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
		}
        int result[] = findTheWay(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
