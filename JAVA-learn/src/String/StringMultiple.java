package String;
//字符串形式的非负整数相乘,结果也用字符串表示
public class StringMultiple {
    public static void main(String[] args) {
        String a = "-114514";
        String b = "20";
        System.out.println(multiple(a,b));
    }
    public static String multiple(String a,String b){
        int res = StringToInt(a)*StringToInt(b);
        return IntToString(res);
    }
    public static int StringToInt(String a){
        int res = 0;
        int i = 0;
        if (a.charAt(0)=='-') {
            i = 1;
        }
        for (int j = i; j < a.length(); j++) {
            res*=10;
            res+=a.charAt(j)-'0';
//            System.out.println("tempres = "+res );
        }

//        System.out.println("res of "+a+" is:"+res);
        return i==0?res:res*-1;
    }
    public static String IntToString(int a){
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(a<0){
            flag = true;
            a = a*-1;
        }
        if(a==0) return "0";
        while (a!=0){
            sb.append((char) ('0'+a%10));
            a/=10;
        }
        if(flag)
            sb.append("-");
        return sb.reverse().toString();
    }
}
