package JavaObject3;

public class Car {
    private String carName;
    private int carAge;
    private String carColor;
    public void show(){
        System.out.println("Car Name: " + carName);
        System.out.println("Car Age: " + carAge);
        System.out.println("Car Color: " + carColor);
    }
    static class Engine{
        private String engineName;
        private int engineAge;
        void show(){
            System.out.println("Engine Name: " + engineName);
            System.out.println("Engine Age: " + engineAge);
        }

    }

    public Car() {
    }

    public Car(String carName, int carAge, String carColor) {
        this.carName = carName;
        this.carAge = carAge;
        this.carColor = carColor;
    }
}
