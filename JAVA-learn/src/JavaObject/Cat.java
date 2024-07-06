package JavaObject;

public class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }

    public Cat() {
        super();
        System.out.println("Cat无参构造");
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void show() {
        System.out.println("Cat--show");
    }

}
