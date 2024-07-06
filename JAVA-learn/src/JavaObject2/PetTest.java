package JavaObject2;

public class PetTest {
    public static void main(String[] args) {
        Cat cat = new Cat(3,"灰");
        Dog dog = new Dog(2,"黑");
        Person p1 = new Person("老王",30);
        Person p2 = new Person("老李",25);
        p1.keepPet(dog,"骨头");
        p2.keepPet(cat,"鱼");
        p1.keepPet(cat,"答辩");
        cat.catchMouse();
        dog.lookHome();;
    }
}
