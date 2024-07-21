package Collection;

import java.util.ArrayList;

public class CollectionDemo4 {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<LihuaCat> lihuaCats = new ArrayList<>();
        ArrayList<PersiaCat> persiaCats = new ArrayList<>();
        cats.add(new LihuaCat("hajimi",1));
        cats.add(new PersiaCat("hajimiPersia",1));
        keepPet(cats);
        keepPet(lihuaCats);
        keepPet(persiaCats);
    }

    public static void keepPet(ArrayList<? extends Cat> list){
        for (Cat cat : list) {
            cat.eat();
        }
    }

}

abstract class Animal{
    String name;
    int age;

    public Animal() {
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

    public abstract void eat();
}

abstract class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public abstract void eat();
}

abstract class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public abstract void eat();
}

class PersiaCat extends Cat {
    public PersiaCat() {
    }

    public PersiaCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+this.getAge()+"岁的波斯猫，正在吃小饼干");
    }
}

class LihuaCat extends Cat {
    public LihuaCat() {
    }

    public LihuaCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+this.getAge()+"岁的狸花猫，正在吃鱼");
    }
}

class Teddy extends Dog {
    public Teddy() {
    }

    public Teddy(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+this.getAge()+"岁的泰迪，正在吃骨头,边吃边蹭");
    }
}

class Hasky extends Dog {
    public Hasky() {
    }

    public Hasky(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+this.getName()+this.getAge()+"岁的哈士奇，正在吃骨头,边吃边拆家");
    }
}

