import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        input.nextLine();
        StringBuilder str=new StringBuilder(input.nextLine());
        
        solve(str.toString(),n);

        input.close();
    }

    public static boolean isAj(String sub, int st, int en, boolean [] isVisited){
        long num = Long.parseLong(sub);
        if(num == 0 || num == 1){
            return false;
        }
        int [] ajSet = {2,3,5,7,11,13,17,19,23,29};
        for(int i = 0; i < ajSet.length; i++){
            if(num == ajSet[i]){
               break;
            }
            if(num%ajSet[i] == 0){
                return false;
            }
        }

        for(int i  = st; i <= en; i++){
            if(isVisited[i] == true){
                return false;
            }
        }

        return true;


    }
	
    public static void solve(String str,int n){
        int count = 0;
        boolean [] isVisited = new boolean[n];
        for(int l = 1; l <= n; l++){
            for(int i = 0 ; i <= str.length() - l; i++){
                String sub = str.substring(i, i + l);
                int st = i; 
                int en = i + l -1;
                //System.out.println(sub + " : " + st + " : " + en + " : "+ isAj(sub, st, en, isVisited));
                if(isAj(sub, st, en, isVisited) == true){
                    count++;
                    for(int k = st; k <= en; k++){
                        isVisited[k] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }
