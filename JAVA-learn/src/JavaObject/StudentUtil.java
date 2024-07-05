package JavaObject;

import java.util.ArrayList;

public class StudentUtil {
    private StudentUtil(){}
    public static int getMaxAge(ArrayList<Student> list){
        int maxAge = list.getFirst().getAge();
        for (Student student : list) {
            int age = student.getAge();
            maxAge = Math.max(age, maxAge);
        }
        return maxAge;
    }
}
