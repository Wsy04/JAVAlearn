package JavaObject3;

public class Car {
    private String carName;
    private int carAge;
    private String carColor;
    private int a = 30;

    public void show() {
        System.out.println("Car Name: " + carName);
        System.out.println("Car Age: " + carAge);
        System.out.println("Car Color: " + carColor);
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarAge() {
        return carAge;
    }

    public void setCarAge(int carAge) {
        this.carAge = carAge;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    class Engine {
        private String engineName;
        private int engineAge;
        private int a = 20;

        public Engine() {
        }

        public Engine(String engineName, int engineAge) {
            this.engineName = engineName;
            this.engineAge = engineAge;
        }

        void show() {
            System.out.println("Engine Name: " + engineName);
            System.out.println("Engine Age: " + engineAge);
        }

        public String getEngineName() {
            return engineName;
        }

        public void setEngineName(String engineName) {
            this.engineName = engineName;
        }

        public int getEngineAge() {
            return engineAge;
        }

        public void setEngineAge(int engineAge) {
            this.engineAge = engineAge;
        }

        public void showA() {
            int a = 10;
            System.out.println("a = " + a);//10
            System.out.println("a = " + this.a);//20
            System.out.println("a = " + Car.this.a);//30
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
