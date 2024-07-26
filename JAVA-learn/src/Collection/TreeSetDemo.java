package Collection;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("zz",18));
        people.add(new Person("za",18));
        people.add(new Person("zz",19));
        System.out.println(people);
    }
}
