package JavaObject3;

public class Test {
    public static void main(String[] args) {

        Swim swim = new Swim() {

            @Override
            public void swim() {
                System.out.println("重写了游泳方法");
            }
        };
        swim.swim();

        Abstract abs = new Abstract(){
            @Override
            public void print() {
                System.out.println("重写了抽象方法");
            }
        };
        abs.print();
    }
}
