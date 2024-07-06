package JavaObject;

public class Animal {
    private String name;
    private int age;
    public void eat(){
        System.out.println("吃饭");
    }
    public void drink(){
        System.out.println("喝水");
    }
    public Animal(){
        System.out.println("Animal Class 无参构造");
    }

    public Animal(String name, int age) {
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
}
