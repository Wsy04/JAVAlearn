package JavaObject;

public class Student {
    private String name;
    private int age;
    public static String teacherName = "Bili";

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getTeacherName() {
        return teacherName;
    }

    public static void setTeacherName(String teacherName) {
        Student.teacherName = teacherName;
    }
    public void printInfo(){
        System.out.println("姓名:"+name+" 年龄"+age+" 老师:"+teacherName);
    }
}
