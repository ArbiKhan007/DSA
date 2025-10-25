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
      
      for(int i = 0; i < arr.length; i++){
        char ch = arr[i];
        if(ch >= 'a' && ch <= 'z'){
          char chU = (char)(ch - 'a' + 'A');
          arr[i] = chU;
        }else if(ch >= 'A' && ch <= 'Z'){
          char chL = (char)(ch - 'A' + 'a');
          arr[i] = chL;
        }else{
          arr[i] = ch;
        }
      }
      System.out.println(String.valueOf(arr));
  }
}
