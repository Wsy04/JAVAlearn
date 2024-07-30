import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    private static final ArrayList<Integer> list;
    private static HashMap<Integer,String> hm;
    static {
        list = new ArrayList<>();
        hm = new HashMap<>();
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int i = 1;
        for (String n : numbers) {
            for (String c : colors) {
                list.add(i);
                hm.put(i, c+n);
                i++;
            }
        }
        hm.put(i,"小王");
        list.add(i++);
        hm.put(i,"大王");
        list.add(i);
    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        TreeSet<Integer> landlord = new TreeSet<>();//底牌
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        //遍历牌堆
        int j = 0;
        while (j<list.size()-3){
             player1.add(list.get(j++));
             player2.add(list.get(j++));
             player3.add(list.get(j++));
        }
        landlord.add(list.get(j++));
        landlord.add(list.get(j++));
        landlord.add(list.get(j));
        //发牌结果
        LookPoker("周扒皮",player1);
        LookPoker("王牢五",player2);
        LookPoker("黄世仁",player3);
        LookPoker("底牌",landlord);
    }

    public void LookPoker(String name,TreeSet<Integer> list){
        System.out.print(name+":");
        for(int i:list){
            System.out.print(hm.get(i)+" ");
        }
        System.out.println();
    }

}
