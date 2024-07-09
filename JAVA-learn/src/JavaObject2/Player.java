package JavaObject2;

public class Player extends Sportsman {
    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }

    public void learn() {
        System.out.println("学习");
    }

}
