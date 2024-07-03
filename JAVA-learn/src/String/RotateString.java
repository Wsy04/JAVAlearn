package String;
//判断一个字符经过若干次循环移位能否成为另一个字符串
public class RotateString {
    public static void main(String[] args) {
        String A = "adsjoi";
        String B = "dsjoia";
        System.out.println(CanRotateTo(A,B));
    }
    public static String Rotata(String s){
        if(s.length()==1) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s,1,s.length());
        sb.append(s.charAt(0));
        return sb.toString();
    }
    public static boolean CanRotateTo(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.equals(s2)) return true;
            s1 = Rotata(s1);
        }
        return false;
    }
}
