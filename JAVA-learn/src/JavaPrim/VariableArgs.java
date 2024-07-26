package JavaPrim;

//可变参数
public class VariableArgs {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2, 4, 25, 35, 124));
    }

    public static int getSum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }
}
