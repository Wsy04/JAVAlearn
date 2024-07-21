package AlgorithmTest;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm1 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("z1",18,200),
                new Student("s1",18,200),
                new Student("x1",16,160),
                new Student("x2",16,160),
                new Student("x3",16,100),
                new Student("x4",16,160),

        };
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, (s1, s2) -> {
            if(s1.getAge()!=s2.getAge()){
                return s1.getAge()-s2.getAge();
            }else if(s1.getHeight()!=s2.getHeight()) {
                return s1.getHeight() - s2.getHeight();
            }else {
                return s1.getName().compareTo(s2.getName());
            }

        });
        System.out.println(Arrays.toString(students));
    }
}
