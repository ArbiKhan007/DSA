import java.util.*;

public class Main {
    
    static void ptice(int n, String key) {
        String ap = "ABC";
        int as = 0;
        String bp = "BABC";
        int bs = 0;
        String gp = "CCAABB";
        int gs = 0;
        int i = 0;
        while(i < n){
            char ach = ap.charAt(i%ap.length());
            char bch = bp.charAt(i%bp.length());
            char gch = gp.charAt(i%gp.length());
            char och = key.charAt(i);
            if(ach == och){
                as++;
            }
            if(bch == och){
                bs++;
            }
            if(gch == och){
                gs++;
            }
            i++;
        }

        int max = Math.max(Math.max(gs, bs), as);
        System.out.println(max);
        if(max == as){
            System.out.println("Adrian");
        }
        if(max == bs){
            System.out.println("Bruno");
        }
        if(max == gs){
            System.out.println("Goran");
        }

    }  
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String str = sc.next();
        ptice(n, str);
        sc.close();
    }
}
