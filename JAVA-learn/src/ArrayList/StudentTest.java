package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("U114514","张三",18);
        Student s2 = new Student("U114516","张四",66);
        Student s3 = new Student("U114515","张五",19);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        PrintAllStudent(students);
//        UpdateStudent(s1);
//        PrintAllStudent(students);
//        System.out.println(FindStudentId(students,"U114514"));
        PrintStudentById(students,"U114514");
    }
    public static void UpdateStudent(Student s){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入新的名称");
        s.setName(sc.next());
        System.out.println("输入新的年龄");
        s.setAge(sc.nextInt());
        System.out.println("修改完成");
    }
    public static void PrintAllStudent(ArrayList<Student> list){
        for (Student student : list) {
            student.printInfo();
        }
    }
    public static int FindStudentId(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    public static void PrintStudentById(ArrayList<Student> list,String id){
        list.get(FindStudentId(list,id)).printInfo();
    }
}
