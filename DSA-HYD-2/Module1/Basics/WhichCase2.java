import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Capital charcter -> 65 to 90 
        // Lower Case character -> 97 to 122 
        Scanner scn = new Scanner(System.in);
        char ch = scn.next().charAt(0);
        if(ch >= 'A' && ch <= 'Z'){
            System.out.println(1);
        }else if(ch >= 'a' &&  ch <= 'z'){
            System.out.println(0);
        }else{
            System.out.println(-1);
        }
    }
}
