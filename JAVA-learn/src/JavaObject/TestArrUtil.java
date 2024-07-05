package JavaObject;

public class TestArrUtil {
    public static void main(String[] args) {
        int[] arr = {114,514,1919,810};
        double[] doubles = {10.0,20.0,30};
        System.out.println(ArrUtil.printArr(arr));
        System.out.println(ArrUtil.getAverage(doubles));
    }
}
