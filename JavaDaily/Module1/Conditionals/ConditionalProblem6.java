import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        boolean conditionA = (a%2==1);
        boolean conditionB = (b%2==1);
        if(conditionA && conditionB){
            System.out.println("we are odd");  
        }else{
            System.out.println("we are simple");
        }
    }
}
