package JavaObject3;

public class InterImple extends InterAdapt {
    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method6() {
        System.out.println("使用适配器设计模式,在适配器中进行空重写,再写一个类继承适配器需要哪个类就重写哪个");
    }

    @Override
    public void method7() {
        System.out.println("可以将适配器定义为抽象类,防止适配器对象的创建");
    }

    //    @Override
//    public void method2() {
//        System.out.println("override method2");
//    }
    public static void show(){
        System.out.println("show from Class");
    }

}
