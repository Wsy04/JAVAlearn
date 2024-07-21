package Collection;

import java.util.ArrayList;

public class CollectionDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        ArrayList<Ye> list3 = new ArrayList<>();
        ArrayList<Fu> list4 = new ArrayList<>();
        ArrayList<Zi> list5 = new ArrayList<>();
        method(list1);
        method(list2);
        method1(list3);
        method1(list4);
        method1(list5);
        method2(list3);
        method2(list4);
        method2(list5);

    }

    public static<E> void method(ArrayList<E> list) {
        System.out.println(list);
    }

    public static void method1(ArrayList<? extends Ye> list) {
        System.out.println("ok");
    }

    public static void method2(ArrayList<? super Zi> list) {
        System.out.println("OK");
    }
}

class Ye{}
class Fu extends Ye{}
class Zi extends Fu{}


