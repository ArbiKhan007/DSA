import java.util.Scanner;

public class Main {
    public static int binaryToDecimal(int binaryNumber) {
        int decimalNumber = 0;
        int pos = 0;
        while(binaryNumber != 0){
            int lastDigit = binaryNumber%10;
            binaryNumber /= 10;
            decimalNumber += lastDigit*(int)Math.pow(2,pos);
            pos++;
        }
        return decimalNumber;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int decimalNumber = binaryToDecimal(n);
        System.out.println(decimalNumber);
    }
}
