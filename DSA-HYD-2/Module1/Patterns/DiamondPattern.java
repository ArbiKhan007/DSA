import java.util.*;
class Main{
	public static void main(String[] args){
                Scanner scn = new Scanner(System.in);
                int tc = scn.nextInt(); // 10
                for(int i = 1; i <= tc; i = i + 1){
                        int n = scn.nextInt();
                        int sp = n/2;
                        int st = 1;
                        for(int row = 1; row <= n; row = row + 1){
                                for(int j = 1; j <= sp; j = j + 1){
                                        System.out.print("  ");
                                }
                                for(int j = 1; j <= st; j = j + 1){
                                        System.out.print("* ");
                                }
                                if(row <= n/2){
                                        sp = sp - 1;
                                        st = st + 2;
                                }else{
                                        sp = sp + 1;
                                        st = st - 2;
                                }
                                System.out.println();
                        }

                }

	}

}
