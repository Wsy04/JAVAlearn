package JUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameFrame extends JFrame {
    //创建一个数组,用于指定图片创建的顺序
    int[] data = new int[16];

    public GameFrame() {
        //初始化界面
        InitJFrame();

        //初始化菜单
        InitMenu();

        //初始化data数组
        InitData();

        //初始化图片
        InitImage();


        //页面设置为可见即显示窗口
        setVisible(true);
    }

    private void InitData() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        for (int i = 0; i < data.length; i++) {
            int r = rand.nextInt(data.length);
            int temp = data[i];
            data[i] = data[r];
            data[r] = temp;
        }
    }

    private void InitImage() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //为图片指定随机的位置
                int num = data[i * 4 + j];
                //创建图片对象
                ImageIcon icon = new ImageIcon("C:\\Users\\20578\\IdeaProjects\\PuzzleGame" +
                        "\\image\\animal\\animal3\\" + num + ".jpg");
                //创建管理容器对象
                JLabel label = new JLabel(icon);
                //指定图片位置
                label.setBounds(icon.getIconWidth() * j + 83, icon.getIconHeight() * i + 134, icon.getIconWidth(), icon.getIconHeight());
                //给图片增加边框
                //raised表示凸
                //lowered表示凹
                label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK,Color.yellow));
                //将容器添加到窗体
                getContentPane().add(label);
                num++;
            }
        }
        //添加背景图片
        ImageIcon background = new ImageIcon("C:\\Users\\20578\\IdeaProjects" +
                "\\PuzzleGame\\image\\background.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(40, 40, background.getIconWidth(), background.getIconHeight());
        getContentPane().add(backgroundLabel);

    }

    private void InitMenu() {
        //创建菜单对象
        JMenuBar menuBar = new JMenuBar();
        //创建菜单上面的选项对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重置本关");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem exitItem = new JMenuItem("退出游戏");
        JMenuItem aboutItem = new JMenuItem("作者信息");

        //将条目添加到选项对象当中
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(exitItem);
        aboutMenu.add(aboutItem);

        //将选项添加到菜单上面
        menuBar.add(functionMenu);
        menuBar.add(aboutMenu);

        //将菜单显示在游戏界面上
        setJMenuBar(menuBar);
    }

    private void InitJFrame() {
        //界面大小
        setSize(603, 680);
        //界面标题
        setTitle("拼图v1.0");
        //置于顶层
        setAlwaysOnTop(true);
        //设置居中
        setLocationRelativeTo(null);
        //设置关闭模式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //按坐标添加组件,取消默认的居中添加
        setLayout(null);
    }

}
