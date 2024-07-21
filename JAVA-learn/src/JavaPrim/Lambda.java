package JavaPrim;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        String[] strings = {"aminos","hajimi","manbaout"};
        Arrays.sort(strings,  (o1, o2) ->  o1.length()-o2.length());
        System.out.println(Arrays.toString(strings));
    }
}
