import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

	public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) { // 5
        ArrayList<ArrayList<Integer>> mainLi = new ArrayList<>(); // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
        ArrayList<Integer> fRow = new ArrayList<>(); // [1]
        fRow.add(1); 
        mainLi.add(fRow);

        for(int row = 1; row < numRows; row++){ // row = 4, 4 < 5
            ArrayList<Integer> currRow = new ArrayList<>(); // [1]
            currRow.add(1);
            ArrayList<Integer> prevRow = mainLi.get(currRow - 1); // [1, 3, 3, 1]
            for(int i = 0; i < prevRow.size() - 1; i++){ // i = 2, 2 < 2
                int sum = prevRow.get(i) + prevRow.get(i + 1); // 2 + 1 -> 3
                currRow.add(sum);
            }
            currRow.add(1);
            mainLi.add(currRow);
        }

        return mainLi;

    }
}
