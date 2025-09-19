import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       boolean resp = determineSecondLastDigit(n);
       if(resp){
        System.out.println("Yes");
       }else{
        System.out.println("No");
       }
    }

    public static boolean determineSecondLastDigit(int n) {
        int secLastDigit = (n/10)%10;
        if(secLastDigit == 0){
            return true;
        }else{
            return false;
        }
    }
}
