package String;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args){
        String username = "wsy";
        String passwd = "114514";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Please input the username");
            String inputUsername = sc.next();
            System.out.println("Please input the passwd");
            String inputpasswd = sc.next();
            if(username.equals(inputUsername)&&passwd.equals(inputpasswd)){
                System.out.println("login success");
                break;
            }
            else
                System.out.println("Username or Password is incorrect,"+(2-i)+" times chance left");
        }

    }
}
