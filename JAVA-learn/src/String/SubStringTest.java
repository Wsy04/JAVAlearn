package String;

public class SubStringTest {
    public static void main(String[] args) {
        String s1 = "13326459876";
        System.out.println(s1);
        System.out.println(PhoneNumberMask(s1));
//        String s2 = "489123200411031224";
//        PrintIdentityInfo(s2);
//        String talk = "真是CS,SC的cs,CS";
//        System.out.println(SensitiveWordReplace(talk));
//        String s = "114411";
//        System.out.println(Palindrome(s));
    }
    public static String PhoneNumberMask(String phoneNumber){
        //将电话号码的中间部分进行屏蔽
        return phoneNumber.substring(0, 3) +
                "****" +
                phoneNumber.substring(7, 11);
    }
    public static void PrintIdentityInfo(String identityId){
        //打印身份证号中的出生年月日以及性别信息
        System.out.println("出生年月日:"+identityId.substring(6,10)+"年"+
                identityId.substring(10,12)+"月"+identityId.substring(12,14)+"日");
        System.out.println((identityId.charAt(16)%2==1)?"男":"女");

    }
    public static String SensitiveWordReplace(String talk){
        //敏感词替换
        String[] arr = {"BYD","CS","你吗"};
        for (String s : arr) {
            talk = talk.replace(s, "***");
        }
        return talk;
    }
    public static boolean Palindrome(String str){
        //判断某字符串是否是回文字符串
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1 = new StringBuilder(str);
        sb.reverse();
        return sb1.compareTo(sb) == 0;
    }

}
