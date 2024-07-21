package Exception;

public class Demo1 {
    public static void main(String[] args) {
        int x = 1, y = 0;

        try{//try监控区域
            new Demo1().c(x,y);

        }catch(ArithmeticException e){//catch捕获异常
            System.out.println("不能除以0");
            System.out.println(e);
        }finally {//无论异常与否一定会运行内容
            System.out.println("finally");
        }

        try{
            System.out.println(x/y);
        }catch(Error e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Throwable t){
            System.out.println("Throwable");
        }finally {
            System.out.println("finally");
        }
        //finally可以省略,一般用于善后,如关闭资源区等
    }
    public void a(){
        b();
    }
    public void b(){
        a();
    }

    public void c(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();//throw在方法中主动抛出异常
        }
        System.out.println(a/b);
    }
}
