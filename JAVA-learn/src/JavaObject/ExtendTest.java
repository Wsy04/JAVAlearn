package JavaObject;

public class ExtendTest {
    public static void main(String[] args) {
        RagDoll ragDoll = new RagDoll();
        ragDoll.eat();
        ragDoll.catchMouse();
        ragDoll.drink();

        Hasky hasky = new Hasky();
        hasky.BreakHome();
        hasky.drink();
        hasky.defendHouse();
        hasky.eat();

        hasky.drink();

        Teddy teddy = new Teddy();
        teddy.eat();
    }
}
