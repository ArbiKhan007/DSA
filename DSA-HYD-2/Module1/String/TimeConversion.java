import java.util.*;

public class Main {
    static void timeConversion(String s) {
        String [] arr = s.split(":");
        String am_pm = arr[2].substring(2);
        if(am_pm.equals("AM") == true && arr[0].equals("12") == true){
            arr[0] = "00";
        }else if(am_pm.equals("PM") == true){
            String hh = (Integer.parseInt(arr[0]) + 12)  + "";
            if(hh.equals("24")){
                hh = "12";
            }
            arr[0] = hh;
        }

        String militaryTime = arr[0] + ":" + arr[1] + ":" + arr[2].substring(0,2);
        System.out.println(militaryTime);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        timeConversion(str);
        sc.close();
    }
}
