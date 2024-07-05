package JavaObject;

public class ArrUtil {
    private ArrUtil(){}
    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i<arr.length-1) sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
    public static double getAverage(double[] arr){
        double avg = 0;
        for (double v : arr) {
            avg+=v;
        }
        return avg/arr.length;
    }
}
