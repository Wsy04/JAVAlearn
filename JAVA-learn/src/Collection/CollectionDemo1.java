package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<String>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        System.out.println(collection);
//        collection.clear();
        collection.remove("B");
        System.out.println(collection);
        if(collection.contains("A")){
            System.out.println("Collection contains A");
        }
    }
}
