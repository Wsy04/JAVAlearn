package String;
//截取字符串中最后一个单词
public class OneLastWord {
    public static void main(String[] args) {
        String str = "The first time i came to Le Louvre";
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
