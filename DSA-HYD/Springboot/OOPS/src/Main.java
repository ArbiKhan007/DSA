import java.util.*;

public class Main{
    public static void main(String [] args) {
        // If we are using reference of our parent class.
        // Then the methods that are visisble during compile time is the methods that are defined in parent class.
        // At RUntime execution will be bottom to up first we are going to see that method is available in child class if not then we will check parent class.
     Human somendra = new Somendra();
     somendra.holdThings();
    }
}

