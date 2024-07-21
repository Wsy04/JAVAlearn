package Exception;

public class Demo2 {
    public static void main(String[] args) {
        int x = 1,y = 0;
        try {
            System.out.println(x/y);
        } catch (Exception e) {
//            e.printStackTrace();
            System.exit(1);
        } finally {
        }
    }
}
