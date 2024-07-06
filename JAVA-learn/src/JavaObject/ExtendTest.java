package JavaObject;

public class ExtendTest {
    public static void main(String[] args) {
//        RagDoll ragDoll = new RagDoll();
//        ragDoll.eat();
//        ragDoll.catchMouse();
//        ragDoll.drink();
//
//        Hasky hasky = new Hasky();
//        hasky.BreakHome();
//        hasky.drink();
//        hasky.defendHouse();
//        hasky.eat();
//
//        hasky.drink();
//
//        Teddy teddy = new Teddy();
//        teddy.eat();
        Cat cat = new Cat("helloKitty",18);
        Cat cat1 = new Cat();
        System.out.println(cat.getName());
        System.out.println(cat.getAge());
        System.out.println(cat1.getName());
        System.out.println(cat1.getAge());


    }
}
