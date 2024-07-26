package Collection.Map;

import java.util.*;

public class MapDemo1 {
    public static void main(String[] args) {
        HashMap<Student,String> map = new HashMap<>();
        Student s1 = new Student("John", 22);
        Student s2 = new Student("Jane", 23);
        Student s3 = new Student("John", 24);
        map.put(s1,"China");
        map.put(s2,"England");
        map.put(s3,"America");
        for (Map.Entry<Student, String> studentStringEntry : map.entrySet()) {
            System.out.println(studentStringEntry);
        }
        HashMap<String,Integer> map2 = new HashMap<>();
        String[] arr = {"A","B","C","D"};
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            int index = random.nextInt(arr.length);
            map2.put(arr[index],map2.getOrDefault(arr[index],0)+1);
        }
        int max = 0;
        for (Map.Entry<String,Integer> entry : map2.entrySet()) {
            max = Math.max(max,entry.getValue());
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map2.entrySet()) {
            if(max == stringIntegerEntry.getValue())
                System.out.println(stringIntegerEntry.getKey());
        }

    }
}


