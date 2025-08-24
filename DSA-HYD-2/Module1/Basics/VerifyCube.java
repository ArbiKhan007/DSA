import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long a = scn.nextLong();
        long b = scn.nextLong();
        long lhs = (a+b)*(a+b)*(a+b);
        long rhs = a*a*a + b*b*b + 3*a*a*b + 3*a*b*b;
        boolean resp = lhs == rhs;
        System.out.println(lhs);
        System.out.println(rhs);
        if(resp){
            System.out.println("VERIFIED");
        }else{
            System.out.println("NOT VERIFIED");
        }
    }
}
