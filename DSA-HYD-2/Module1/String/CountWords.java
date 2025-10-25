import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    String p = sc.nextLine();
    while (t > 0) {
      String s = sc.nextLine();
      System.out.println(countWords(s));
      t--;
    }
  }

  public static int countWords(String s) {
    int count = 0;
    int i = 0;
    int j = 0;
    while(j < s.length()){
      if(i == j && s.charAt(j) != ' '){
        count++;
        j++;
      }else if(s.charAt(j) != ' '){
        j++;
      }else{
        i = j;
        j++;
        i++;
      }
    }
    return count;
  }
}
