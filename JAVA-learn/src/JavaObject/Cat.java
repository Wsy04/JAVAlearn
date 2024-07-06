package JavaObject;

public class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }

    public Cat() {
        this("哈吉米",0);
    }

    public Cat(String name, int age) {
        super(name, age);
    }

}
