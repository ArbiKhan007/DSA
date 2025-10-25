import java.util.*;

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();
    toggleCase(n, str);
  }

  static void toggleCase(int n, String str) {
    char [] arr = str.toCharArray();
      String ans = "";
      for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        if(ch >= 'a' && ch <= 'z'){
          char chU = (char)(ch - 'a' + 'A');
          ans += chU;
        }else if(ch >= 'A' && ch <= 'Z'){
          char chL = (char)(ch - 'A' + 'a');
          ans += chL;
        }else{
          ans += ch;
        }
      }
      System.out.println(ans);
  }
}
