package JavaObject;

public class Dog extends Animal{
    public void defendHouse(){
        System.out.println("狗看家");
    }
    @Override
    public void eat(){
        System.out.println("狗吃饭");
    }
}
