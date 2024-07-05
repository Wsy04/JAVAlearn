package JavaObject;

import java.util.ArrayList;

public class StudentTest {

    public static void main(String[] args) {
        Student s1 = new Student("wei",18);
        Student s2 = new Student("shen",19);
        Student s3 = new Student("yang",20);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
//        s1.printInfo();
//        System.out.println(Student.getTeacherName());
        System.out.println(StudentUtil.getMaxAge(list));
    }
}
