package String;
//截取字符串中最后一个单词
public class OneLastWord {
    public static void main(String[] args) {
        String str = "第一次去 卢浮宫";
        System.out.println(getOneLastWord(str));
    }
    public static String getOneLastWord(String str){
        for (int length = str.length()-1; length >= 0; length--) {
            if(str.charAt(length)==' ')
            {
                return str.substring(length+1);
            }
        }
        return str;
    }
}
