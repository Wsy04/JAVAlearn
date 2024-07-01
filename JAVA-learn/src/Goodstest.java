public class Goodstest {
    public static void main(String[] args){
        Goods[] arr = new Goods[3];
        Goods g1 = new Goods("1","C++课程",100.0,20);
        Goods g2 = new Goods("2","JAVA课程",200.0,2);
        Goods g3 = new Goods("3","Python课程",150.0,10);
        arr[0] = g1;
        arr[1] = g2;
        arr[2] = g3;
        for (Goods goods : arr) {
            goods.printInfo();
        }
    }
}
