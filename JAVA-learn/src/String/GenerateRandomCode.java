package String;

import java.util.Random;

public class GenerateRandomCode {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(6));
        System.out.println(generate(7));
        System.out.println(generate(8));

    }
    public static String generate(int len){
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[52];
        for (int i = 0; i < chars.length; i++) {
            if(i<26){
                chars[i] = (char) ('a'+i);
            }
            else {
                chars[i] = (char) ('A'+i-26);
            }
        }
        char[] digits = new char[10];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char) ('0'+i);
        }
        Random r = new Random();
        for (int i = 0; i < len-1; i++) {
            sb.append(chars[r.nextInt(52)]);
        }
        sb.append(digits[r.nextInt(10)]);
        char[] charSb = sb.toString().toCharArray();
        DiffuseString.swap(charSb,r.nextInt(len),len-1);
        return new String(charSb);
    }
    
}
