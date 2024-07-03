package String;

public class SubStringTest {
    public static void main(String[] args) {
//        String s1 = "13326459876";
//        System.out.println(s1);
//        System.out.println(PhoneNumberMask(s1));
//        String s2 = "489123200411031224";
//        PrintIdentityInfo(s2);
//        String talk = "真是CS,SC的cs,CS";
//        System.out.println(SensitiveWordReplace(talk));
//        String s = "114411";
//        System.out.println(Palindrome(s));
    }
    public static String PhoneNumberMask(String phoneNumber){
        return phoneNumber.substring(0, 3) +
                "****" +
                phoneNumber.substring(7, 11);
    }
    public static void PrintIdentityInfo(String identityId){
        System.out.println("出生年月日:"+identityId.substring(6,10)+"年"+
                identityId.substring(10,12)+"月"+identityId.substring(12,14)+"日");
        System.out.println((identityId.charAt(16)%2==1)?"男":"女");

    }
    public static String SensitiveWordReplace(String talk){
        String[] arr = {"BYD","CS","你吗"};
        for (String s : arr) {
            talk = talk.replace(s, "***");
        }
        return talk;
    }
    public static boolean Palindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1 = new StringBuilder(str);
        sb.reverse();
        return sb1.compareTo(sb) == 0;
    }

}
