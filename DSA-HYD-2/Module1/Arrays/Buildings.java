import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
   Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();
   int [] arr = new int[n];
   for(int i = 0; i < n; i++){
    arr[i] = scn.nextInt();
   }

   printBuildings(arr);
  }

  public static int getMaxElement(int [] arr){
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] > max){
        max = arr[i];
      }
    }
    return max;
  }

  public static void printBuildings(int [] arr){
    int maxFloor = getMaxElement(arr);
    int currFloor = maxFloor;

    while(currFloor > 0){
      for(int i = 0; i < arr.length; i++){
        if(arr[i] >= currFloor){
          System.out.print("*\t");
        }else{
          System.out.print("\t");
        }
      }
      System.out.println();
      currFloor--;
    }

  }
}
