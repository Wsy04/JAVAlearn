package Collection.Map;

import java.util.TreeMap;

public class MapDemo2 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>((o1, o2) -> o2-o1);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        TreeMap<Student,String> map2 = new TreeMap<>((o1, o2) -> {
            if(o1.getAge()!=o2.getAge())
                return o1.getAge()-o2.getAge();
            return o1.getName().compareTo(o2.getName());
        });
        Student s1 = new Student("John", 22);
        Student s2 = new Student("Jane", 23);
        Student s3 = new Student("John", 24);
        Student s4 = new Student("Jane", 23);
        map2.put(s1,"China");
        map2.put(s2,"Japan");
        map2.put(s3,"Korea");
        map2.put(s4,"North Korea");
        map2.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
