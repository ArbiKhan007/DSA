import java.io.*;
import java.util.*;

public class Main {
	static int isPalindrome(String str)
    {
        String res = "";
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                res += ch;
            }else if(ch >= 'A' && ch <= 'Z'){
                res += (char)(ch - 'A' + 'a');
            }
        }
        int i = 0;
        int j = res.length() - 1;
        while(i < j){
            char chi = res.charAt(i);
            char chj = res.charAt(j);
            if(chi != chj){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);        
    }
}
