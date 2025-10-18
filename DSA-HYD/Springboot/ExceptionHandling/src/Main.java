import java.util.*;
public class Main{
    public static void main(String [] args){
        System.out.println("Inside Program");
        int x = 10;
        int [] arr = new int[4];

        arr[10] = 20/0;
//        try{
//
//        }catch (NullPointerException e){
//            System.out.println("Inside null pointer catch");
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Inside arrayIndex out of bound catch");
//        }catch (Exception e){
//            System.out.println("Parent of all the exception");
//        }

        // Checked exceptions need to be handled compile time only.
    try{
        Class.forName("com.example.NonExistentClass");
    }catch (Exception e){

    }

    }
}