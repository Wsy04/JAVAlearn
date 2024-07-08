package JavaObject2;

public class AbstractFrog extends AbstractAnimal{
    public AbstractFrog() {
    }

    public AbstractFrog(String name, int age) {
        super(name, age);
    }

    @Override
    public void drink() {
        System.out.println(this.getName()+"青蛙"+"喝水");
    }

    @Override
    public void eat() {
        System.out.println(this.getName()+"青蛙"+"吃虫子");
    }
}
