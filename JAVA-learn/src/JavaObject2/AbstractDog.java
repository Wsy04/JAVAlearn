package JavaObject2;

public class AbstractDog extends AbstractAnimal{
    public AbstractDog() {
    }

    public AbstractDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void drink() {
        System.out.println(this.getName()+"狗"+"喝水");
    }

    @Override
    public void eat() {
        System.out.println(this.getName()+"狗"+"吃骨头");
    }
}
