import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int reveresed = 0;
      while(n != 0){
        int q = n/10; // rest of the number 
        int rem = n%10; // last value 
        reveresed = reveresed*10 + rem;
        n = q;
      }
      System.out.println(reveresed);
    }
}
