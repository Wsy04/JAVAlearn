package JavaObject2;

public class AbstractStudent extends AbstractPerson{
    public AbstractStudent() {
    }

    public AbstractStudent(int age, String name) {
        super(age, name);
    }

    @Override
    public void work() {
        System.out.println("学生的工作是学习");
    }
}
