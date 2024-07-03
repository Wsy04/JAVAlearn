public class ReverseString {
    public static void main(String[] args){
        String s1 = "ajwldi";
        System.out.println(reverse(s1));
    }
    public static String reverse(String s){
        StringBuilder str = new StringBuilder();
        str.append(s);
        str.reverse();
        return str.toString();
    }

}
