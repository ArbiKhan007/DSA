public class Human {
    int eyes;
    int nose;
    int legs;
    int hands;
    String name;

    public Human(String name){
      // We want to call unparametrized constructor from parametrized constructor that's why we have written this()
        this.name = name;
        this.eyes = 2;
        this.nose = 1;
        this.legs = 2;
        this.hands = 2;
    }

    public Human(){
        System.out.println("Hello How are you ? ");
        this("Kgf");
    }

    public void walk(){
        System.out.println("Walking");
    }

    public void holdThings(){
        System.out.println("Hold things");
    }
}
