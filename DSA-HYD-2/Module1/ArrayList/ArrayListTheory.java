import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(); // []
        System.out.println(li); 
        li.add(10, 20);  // At 10th index we want to insert value 20
        li.add(20);
        li.add(30);
        int size = li.size(); // 3
        System.out.println(size);
        System.out.println(li);
        li.set(1, 100); 
        System.out.println(li);
        li.add(0, 200);
        System.out.println(li);
        li.add(0, 40);
        System.out.println(li);
    }
}
