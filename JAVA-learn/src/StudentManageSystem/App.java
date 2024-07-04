package StudentManageSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择你的操作:1登录 2注册 3忘记密码 4退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1"-> login(list);
                case "2"-> register(list);
                case "3"-> forgetPassword(list);
                case "4"-> System.exit(0);
                default -> System.out.println("无此选项,重新输入");
            }
        }
    }
    public static void login(ArrayList<User> list){
        System.out.println("登录");
        Scanner sc = new Scanner(System.in);
        String username,password;
        for (int i = 0;i<3;i++) {
            System.out.println("请输入用户名:");
            username = sc.next();
            int index = getIndex(list,username);
            if(index==-1){
                System.out.println("用户名不存在,请先注册");
                return;
            }

            System.out.println("请输入密码");
            password = sc.next();

            while (true) {
                String code = getCode();
                System.out.println("验证码为:"+code);
                System.out.println("请输入验证码");
                if(!code.equals(sc.next())){
                    System.out.println("验证码错误");
                }
                else break;
            }


            User user = new User(username,password,null,null);
            if(checkUserInfo(list,user)){
                System.out.println("密码正确,登录成功");
                System.out.println(username+"登录成功");
                StudentManage.ManageSystem();
                return;
            }
            else System.out.println("登录失败,剩余"+(2-i)+"次机会");
        }
        System.out.println("连续三次登录失败,客户端已锁定,请重新启动客户端");

    }
    public static void register(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        String personId;
        String phoneNumber;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            if (checkUsername(username)){
                if(getIndex(list,username)!=-1){
                    System.out.println("用户名已经存在");
                }
                else {
                    System.out.println("用户名可用");
                    break;
                }
            }
            else System.out.println("用户名格式不正确");
        }
        while (true) {
            System.out.println("请输入密码");
            password = sc.next();
            System.out.println("请确认密码");
            if(password.equals(sc.next())){
                System.out.println("密码创建成功");
                break;
            }
            else {
                System.out.println("两次输入不一致,重新创建密码");
            }
        }
        while (true) {
            System.out.println("请输入身份证号");
            personId = sc.next();
            if(checkPersonId(personId)){
                System.out.println("身份证号格式正确");
                break;
            }
            else {
                System.out.println("身份证号格式不正确,请重新输入");
            }
        }
        while (true) {
            System.out.println("请输入手机号");
            phoneNumber = sc.next();
            if(checkPhoneNumber(phoneNumber)){
                System.out.println("手机号格式正确");
                break;
            }
            else {
                System.out.println("手机号格式不正确,请重新输入");
            }
        }
        User user = new User(username,password,personId,phoneNumber);
        list.add(user);
        for (User user1 : list) {
            user1.printInfo();
        }
    }//注册功能
    public static void forgetPassword(ArrayList<User> list){
        System.out.println("忘记密码");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        int index = getIndex(list,username);
        if(index==-1){
            System.out.println("用户名不存在");
            return;
        }
        System.out.println("请输入身份证号");
        String personId = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();
        User user = list.get(index);
        if(user.getPersonId().equals(personId)&&
                user.getPhoneNumber().equals(phoneNumber)){
            System.out.println("请输入新的密码");
            user.setPassword(sc.next());
            System.out.println("密码已修改");
        }
        else {
            System.out.println("信息有误,找回密码失败");
        }
    }
    public static int getIndex(ArrayList<User> list,String username){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(username)) return i;
        }
        return -1;
    }//由用户名获取索引
    public static boolean checkUsername(String username){
        int len = username.length();
        //用户名的长度在3~15位
        if(len<3||len>15) return false;
        //用户名是字母加数字的组合
        int charCount = 0;
        for (int i = 0; i < len; i++) {
            char ch = username.charAt(i);
            if((ch<='z'&&ch>='a')||(ch<='Z'&&ch>='A')) charCount++;
            else if (ch<='9'&&ch>='0') continue;
            else
                return false;
        }
        //不能是纯数字,字母数量必须为正数
        return charCount > 0;
    }
    public static boolean checkPersonId(String personId){
        int len = personId.length();
        if(len!=18) return false;
        if(personId.charAt(0)=='0') return false;
        for (int i = 0; i < len; i++) {
            char ch = personId.charAt(i);
            if(ch<='9'&&ch>='0') continue;
            else if(i<len-1) return false;
            else if(ch=='X'||ch=='x') continue;
            else return false;
        }

        return true;
    }
    public static boolean checkPhoneNumber(String phoneNumber){
        int len = phoneNumber.length();
        if(len!=11) return false;
        if(phoneNumber.charAt(0)=='0') return false;
        for (int i = 0; i < len; i++) {
            char ch = phoneNumber.charAt(i);
            if(ch>='0'&&ch<='9') continue;
            else return false;
        }
        return true;
    }
    public static String getCode(){
        int len = 5;
        Random r = new Random();
        char[] chs = new char[52];
        for (int i = 0; i < 52; i++) {
            if(i<26){
                chs[i] = (char) ('a'+i);
            }
            else {
                chs[i] = (char) ('A'+i-26);
            }
        }
        char[] digits = new char[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = (char) ('0'+i);
        }
        char[] codeArr = new char[5];
        for (int i = 0; i < 4; i++) {
            codeArr[i] = chs[r.nextInt(52)];
        }
        codeArr[4] = digits[r.nextInt(10)];
        swap(codeArr,4,r.nextInt(5));

        return new String(codeArr);
    }//生成验证码
    public static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean checkUserInfo(ArrayList<User> list,User user){
        return list.get(getIndex(list,user.getUsername())).getPassword().equals(user.getPassword());
    }
}
