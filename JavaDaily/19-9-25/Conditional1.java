import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        boolean c1 = a%2==1;
        boolean c2 = b%2==1;
        if(c1 && c2){
            System.out.println("we are odd");
        }else{
            System.out.println("we are simple");
        }
    }
}
