package String;

import java.util.Scanner;

public class CountLetter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a string");
        String str = sc.next();
        int smallLetterCount = 0;
        int bigLetterCount = 0;
        int digitCount = 0;
        for (int i = 0; i < str.length(); i++) {
            int currentLetter = str.charAt(i);
            if (currentLetter<='z'&&currentLetter>='a'){
                smallLetterCount++;
            }
            if (currentLetter<='Z'&&currentLetter>='A'){
                bigLetterCount++;
            }
            if (currentLetter<='9'&&currentLetter>='0'){
                digitCount++;
            }
        }
        System.out.println("小写字母"+smallLetterCount+"个 "+
                "大写字母"+bigLetterCount+"个 "+"数字"+digitCount+"个");
    }
}
