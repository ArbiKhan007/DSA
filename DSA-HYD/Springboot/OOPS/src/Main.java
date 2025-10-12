import java.util.*;

public class Main{


    public static void sayHello(){

    }

    public static void sayHello(String name){

    }

    public static void sayHello(String name, int num){

    }

    public static int sayHello(String name){
        return 10;
    }




    public static void main(String [] args) {
        // If we are using reference of our parent class.
        // Then the methods that are visisble during compile time is the methods that are defined in refernece class.
        // At RUntime execution will be bottom to up first we are going to see that method is available in child class if not then we will check parent class.
        Mercedes m = new Mercedes();
        Car a = new Audi();
        ServiceCenter serviceCenter = new ServiceCenter();
        serviceCenter.doServicing(a);
//    Car c = new Car();
        FacebookAccount facebookAccount = new FacebookAccount();
        facebookAccount.setEmail("tiwarisomendra22@gmail.com");
    }
}

