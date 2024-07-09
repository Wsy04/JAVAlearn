package JavaObject3;

public interface Inter {
    public void method1();
    public void method3();
    public void method4();
    public void method5();
    public void method6();
    public void method7();
    public void method8();
    public void method9();

    public default void method2() {
        System.out.println("method2");
    }

    public static void show() {
        System.out.println("show from Interface");
    }

    public static void show2() {
        System.out.println("show2 from Interface");
        show4();
    }

    private static void show4() {
        System.out.println("以下省略一万行");
    }

}
