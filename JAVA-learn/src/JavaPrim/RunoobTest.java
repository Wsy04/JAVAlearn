package JavaPrim;

public class RunoobTest {
    public static void main(String[] args) {
        Nums a = new Nums(10);
        Nums b = new Nums(20);
        System.out.println("Before:a = " + a.num + ", b = " + b.num);
        swap(a, b); // 调用swap方法
        System.out.println("After:a = " + a.num + ", b = " + b.num); // 输出a和b的值
    }

    public static void swap(Nums x, Nums y) {
        int temp = x.num;
        x.num = y.num;
        y.num = temp;
    }
}
