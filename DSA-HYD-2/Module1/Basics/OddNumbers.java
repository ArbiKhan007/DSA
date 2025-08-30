import java.util.*;
  
class Main {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int count = 1;
		while(true){
			int inp = scn.nextInt();
			int rem = inp%2;
			if(rem == 1){
				break;
			}
			count = count + 1;
		}
		System.out.println(count);
	}
}
