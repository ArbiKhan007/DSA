import java.util.*;
import java.io.*;

public class Main {
	static void compressedString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }else{
                char ch =  s.charAt(i);
                sb.append(ch);
                int freq = j - i;
                if(freq > 1){
                   sb.append(freq); 
                }
                i = j;
                j++;
            }
        }

        char ch =  s.charAt(i);
        sb.append(ch);
        int freq = j - i;
        if(freq > 1){
            sb.append(freq); 
        }

        System.out.print(sb);

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            compressedString(s);
            System.out.println();
        }
    }
}

