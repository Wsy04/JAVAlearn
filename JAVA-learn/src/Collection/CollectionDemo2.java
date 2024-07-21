package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection<Person> persons = new ArrayList<Person>();

        Person person1 = new Person("张三",19);
        Person person2 = new Person("李四",18);
        Person person3 = new Person("王五",19);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        Person person4 = new Person("张三",19);
        System.out.println(persons.contains(person4));
        for(Person person : persons){
            System.out.println(person.toString());
        }
        persons.forEach(p -> System.out.println(p.toString()));
    }
}
