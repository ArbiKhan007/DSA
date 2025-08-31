import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int itr = 2;
        boolean flag = true;
        while(itr*itr <= n){
            int rem = n%itr;
            if(rem == 0){
                flag = false;
                break;
            }
            itr = itr + 1;
        }

        if(flag == true){
            System.out.println(n + " is a prime number");
        }else{
            System.out.println(n + " is not a prime number");
        }
    }
}
