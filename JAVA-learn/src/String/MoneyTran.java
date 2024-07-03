package String;

import java.util.Scanner;
//将输入的一千万以内的数字转变为银行惯用的金额字符串形式
public class MoneyTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = "零壹贰叁肆伍陆柒捌玖";
        String bit = "佰拾万仟佰拾元";
        while (true){
            StringBuilder str = new StringBuilder();
            System.out.println("请输入一个金额");
            int money = sc.nextInt();
            if(money<=0||money>=10000000){
                break;
            }
            else{
                for (int length = bit.length()-1; length >= 0; length--) {
                    str.append(bit.charAt(length));
                    str.append(number.charAt(money%10));
                    money/=10;
                }
            }
            str.reverse();
            System.out.println(str);
        }
    }
}
