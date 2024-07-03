package ArrayList;
//学生对象的定义
public class Student {
    private String id;
    private String name;
    private int age;
    public Student() {
    }

    public Student(String id, String name, int age) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void printInfo(){
        System.out.println("学号"+id+"姓名:"+name+" 年龄:"+age);
    }
}

