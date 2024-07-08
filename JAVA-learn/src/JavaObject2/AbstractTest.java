package JavaObject2;

import StudentManageSystem.Student;

public class AbstractTest {
    public static void main(String[] args) {
//        AbstractTeacher teacher = new AbstractTeacher(18,"aaa");
//        System.out.println(teacher.getName()+" "+teacher.getAge());
//        teacher.work();
//        AbstractStudent student = new AbstractStudent(12,"bb");
//        System.out.println(student.getName()+" "+student.getAge());
//        student.work();
        AbstractFrog frog = new AbstractFrog("绿",1);
        AbstractSheep sheep = new AbstractSheep("白",2);
        AbstractDog dog = new AbstractDog("黄",3);
        frog.drink();
        frog.eat();
        sheep.drink();
        sheep.eat();
        dog.drink();
        dog.eat();
    }
}
