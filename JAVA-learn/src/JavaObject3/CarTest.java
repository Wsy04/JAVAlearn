package JavaObject3;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("suv",1,"yellow");
        car.show();
        Car.Engine engine = car.new Engine("qqq",1);
        Car.Engine engine1 = new Car().new Engine("ppp",2);
        engine.show();
        engine.setEngineName("aaa");
        engine.show();
        engine.showA();
        engine1.show();
    }
}
