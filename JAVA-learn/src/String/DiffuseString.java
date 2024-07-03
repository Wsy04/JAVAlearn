package String;

import java.util.Random;
//将字符串打乱
public class DiffuseString {
    public static void main(String[] args) {
        String str = "1145141919810";
        char[] chs = str.toCharArray();
        Random r = new Random();
        for (int i = 0; i < chs.length; i++) {
            swap(chs,i, r.nextInt(chs.length));
        }
        String res = new String(chs);
        System.out.println(res);
    }
    public static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
