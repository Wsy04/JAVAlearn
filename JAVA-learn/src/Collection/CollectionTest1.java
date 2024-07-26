package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionTest1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"114514","9>10","its_time_to","OJoSan");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
