package JavaObject2;

public class AbstractTeacher extends AbstractPerson{
    public AbstractTeacher() {
    }

    public AbstractTeacher(int age, String name) {
        super(age, name);
    }

    @Override
    public void work() {
        System.out.println("教师的工作是教学");
    }
}
