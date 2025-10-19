import java.util.*;
public class Main{

    // Throw -> It is used to throw exception manually by our self
    // Throws -> This throws keyword is used for the declartion that this function throws Exception and whatever the function who is going to call this function needs to handle,

    public static void checkClass() {
        throw new ArithmeticException();
    }

    public static void helper() throws  ClassNotFoundException{
       checkClass();
    }


    public static void main(String [] args) {
        System.out.println("Inside Program");
        int x = 10;
        int [] arr = new int[4];

        //arr[10] = 20/0;
//        try{
//
//        }catch (NullPointerException e){
//            System.out.println("Inside null pointer catch");
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Inside arrayIndex out of bound catch");
//        }catch (Exception e){
//            System.out.println("Parent of all the exception");
//        }

        // Checked exceptions need to be handled compile time only

        throw new NothingException("Just created for fun");
//        try{
//            helper();
//        }catch (Exception e){
//
//        }

    }
}