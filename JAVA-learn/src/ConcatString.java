
public class ConcatString {
    public static void main(String[] args){
        int[] arr = {10,4,5,3};
        System.out.println(ToString(arr));
    }
    public static String ToString(int[] arr){
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
            if(i<arr.length-1) s.append(",");
        }
        s.append("]");
        return s.toString();
    }
}
