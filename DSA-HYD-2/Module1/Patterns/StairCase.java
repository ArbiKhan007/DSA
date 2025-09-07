import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       for(int row = 1; row <= n; row = row + 1){
        int sp = n - row;
        int hc = row;
        for(int j = 1; j <= sp; j = j + 1){
            System.out.print(" ");
        }
        for(int j = 1; j <= hc; j = j + 1){
            System.out.print("#");
        }
        System.out.println();
       }
    }
}


