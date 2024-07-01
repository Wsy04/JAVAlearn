import java.util.Scanner;

public class Goodstest {
    public static void main(String[] args){
        Goods[] arr = new Goods[3];
        Scanner sc = new Scanner(System.in);
        Goods g1 = new Goods(sc.next(),sc.next(),sc.nextDouble(),sc.nextInt());
        Goods g2 = new Goods(sc.next(),sc.next(),sc.nextDouble(),sc.nextInt());
        Goods g3 = new Goods(sc.next(),sc.next(),sc.nextDouble(),sc.nextInt());
        arr[0] = g1;
        arr[1] = g2;
        arr[2] = g3;
        for (Goods goods : arr) {
            goods.printInfo();
        }
    }
}
