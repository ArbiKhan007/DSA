import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long fact = 1;
        while(n >= 1){
            fact = fact*n;
            n = n - 1;
        }
        System.out.println(fact);
    }
}
