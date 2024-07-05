package JavaObject;

public class Hasky extends Dog{
    public void BreakHome(){
        System.out.println("哈士奇在拆家");
    }
    @Override
    public void eat(){
        System.out.println("哈士奇吃东西");
    }
    @Override
    public void drink(){
        System.out.println("哈士奇喝水");
    }
}
