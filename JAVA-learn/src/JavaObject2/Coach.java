package JavaObject2;

public class Coach extends Sportsman {
    public Coach() {
    }

    public Coach(String name, int age) {
        super(name, age);
    }

    public void teach() {
        System.out.println("教导");
    }
}
