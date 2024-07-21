package Exception;

public class Test {
    public static void main(String[] args) {
        try {
            test(11);
        }catch (MyException e){
            System.out.println(e);
        }finally {
            System.out.println("finally");
        }
    }

    public static void test(int a) throws MyException {
        System.out.println("传递的参数为:"+a);
        if(a>10){
            throw new MyException(a);
        }
        System.out.println("ok");
    }
}
