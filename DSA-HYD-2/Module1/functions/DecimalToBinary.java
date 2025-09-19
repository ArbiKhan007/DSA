import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int decimalToBinary(int num){
		int pos = 0;
		int binary = 0;
		while(num != 0){
			int rem = num%2;
			num /= 2;
			binary = rem*(int)Math.pow(10, pos) + binary;
			pos++;
		}
		return binary;
	}
	
	public static void main (String[] args) 
	{

		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int binary = decimalToBinary(num);
		System.out.println(binary);
		
	}
}
