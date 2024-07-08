package JavaObject2;

public class AbstractSheep extends AbstractAnimal{
    public AbstractSheep() {
    }

    public AbstractSheep(String name, int age) {
        super(name, age);
    }

    @Override
    public void drink() {
        System.out.println(this.getName()+"山羊"+"喝水");
    }

    @Override
    public void eat() {
        System.out.println(this.getName()+"山羊"+"吃草");
    }
}
