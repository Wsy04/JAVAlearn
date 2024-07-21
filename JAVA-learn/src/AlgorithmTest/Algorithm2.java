package AlgorithmTest;

import java.util.Arrays;

public class Algorithm2 {
    public static void main(String[] args) {
        int[] arr = new int[12];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[10];
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1]*2+2;
        }
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[20];
        arr3[0] = 1;
        arr3[1] = 2;
        for (int i = 2; i < arr3.length; i++) {
            arr3[i] = arr3[i - 1] + arr3[i - 2];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
