import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      camelCase(s);
      System.out.println(); 
      
    }
  }

  static void camelCase(String s) {
    // int i = 0; 
    // int j = 0;
    // ArrayList<String> li = new ArrayList<>();
    // while(j < s.length()){
    //   char ch = s.charAt(j);
    //   if(ch != '_'){
    //     j++;
    //   }else{
    //     String word = str.substring(i,j);
    //     li.add(word);
    //     j++;
    //     i = j;
    //   }
    // }
    // li.add(str.substring(i, j));
    String [] words = s.split("_");
    String ans = words[0];
    for(int i = 1; i < words.length; i++){
      String word = words[i];
      char chU = (char)(word.charAt(0) - 'a' + 'A');
      String res = chU + word.substring(1);
      ans += res;
    }
    System.out.print(ans);
  }
}
