package JavaObject2;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }

    public void lookHome(){
        System.out.println("狗看家");
    }

    @Override
    public void eat(String something) {
        System.out.println(this.getAge()+"岁的"+this.getColor()+"颜色的狗两只前腿死死地抱住"+something+"猛吃");
    }
}
