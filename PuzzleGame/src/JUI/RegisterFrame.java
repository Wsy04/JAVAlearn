package JUI;

import javax.swing.*;

public class RegisterFrame extends JFrame{
    public RegisterFrame(){
        setSize(500,500);//界面大小
        setTitle("注册");//界面标题
        setAlwaysOnTop(true);//置于顶层
        setLocationRelativeTo(null);//设置居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭模式
        setVisible(true);//设置为可见即显示窗口
    }
}
