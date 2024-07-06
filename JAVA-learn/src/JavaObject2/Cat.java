package JavaObject2;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }

    @Override
    public void eat(String something) {
        System.out.println(this.getAge()+"岁的"+this.getColor()+"颜色的猫眯着眼睛侧着头吃"+something);
    }
}
