package ArrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(114);
        arrayList.add(514);
        arrayList.add(1919);
        arrayList.add(810);
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));
        arrayList.remove((Integer) 114);
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));
        arrayList.add(514);
        System.out.println(arrayList);
        System.out.println("size:"+arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
    }
}
