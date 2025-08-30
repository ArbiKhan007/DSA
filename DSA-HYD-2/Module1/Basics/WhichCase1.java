import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Capital charcter -> 65 to 90 
        // Lower Case character -> 97 to 122 
        Scanner scn = new Scanner(System.in);
        char ch = scn.next().charAt(0);
        int asciiValue = ch;
        if(asciiValue >= 65 && asciiValue <= 90){
            System.out.println(1);
        }else if(asciiValue >= 97 && asciiValue <= 122){
            System.out.println(0);
        }else{
            System.out.println(-1);
        }
    }
}
