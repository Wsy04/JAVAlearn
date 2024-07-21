package Exception;

public class MyException extends Exception {
    private int detail;
    public MyException(int detail) {
        this.detail = detail;
    }
    //异常的打印信息
    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
