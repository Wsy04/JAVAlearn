package JUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个数组,用于指定图片创建的顺序
    int[][] data = new int[4][4];//16个图片位置的索引
    //正确的数据组织方式
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem exitItem = new JMenuItem("退出游戏");
    JMenuItem aboutItem = new JMenuItem("作者信息");
    //统计步数的变量
    int step = 0;
    //空白位置的索引
    int blankX = 0;
    int blankY = 0;
    //当前展示图片的路径
    String path = "../PuzzleGame/image/animal/animal3/";
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
        //按0-15排列
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = i * 4 + j;
            }
        }
        //打乱顺序
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                int r = rand.nextInt(16);
                int x = r/4;
                int y = r%4;
                int temp = data[i][j];
                data[i][j] = data[x][y];
                data[x][y] = temp;
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 0) {
                    blankX = i;
                    blankY = j;
                    break;
                }
            }
        }
    }

    private void InitImage() {
        //清空之前的所有图片
        getContentPane().removeAll();

        //判断是否已经成功
        if(victory()){
            JLabel winLabel = new JLabel(new ImageIcon("../PuzzleGame/image/win.png"));
            winLabel.setBounds(203,283,197,73);
            getContentPane().add(winLabel);

        }

        //显示步数
        JLabel stepCount = new JLabel("步数"+step);
        stepCount.setBounds(50,30,100,20);
        getContentPane().add(stepCount);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //为图片指定随机的位置
                int num = data[i][j];

                //创建图片对象
                ImageIcon icon = new ImageIcon(path + num + ".jpg");

                //创建管理容器对象
                JLabel label = new JLabel(icon);
                //指定图片位置
                label.setBounds(icon.getIconWidth() * j + 83, icon.getIconHeight() * i + 134, icon.getIconWidth(), icon.getIconHeight());
                //给图片增加边框
                //raised表示凸
                //lowered表示凹
                label.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.yellow));
                //将容器添加到窗体
                getContentPane().add(label);
                num++;
            }
        }
        //添加背景图片

        ImageIcon background = new ImageIcon("../PuzzleGame/image/background.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(40, 40, background.getIconWidth(), background.getIconHeight());
        getContentPane().add(backgroundLabel);

        //刷新页面
        getContentPane().repaint();
    }

    private void InitMenu() {
        //创建菜单对象
        JMenuBar menuBar = new JMenuBar();
        //创建菜单上面的选项对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");



        //将条目添加到选项对象当中
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(exitItem);
        aboutMenu.add(aboutItem);

        //给条目添加事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);

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
        //给整个页面增加键盘监听事件
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //判断点击的是哪个
        if(obj == replayItem){
            System.out.println("重新游戏");
            //打乱二维数组
            InitData();
            //计步器清零
            step = 0;
            //重新加载图片
            InitImage();
        }else if(obj == reLoginItem){
            System.out.println("重新登录");
            //关闭当前界面
            setVisible(false);
            //打开登录界面
            new LoginFrame();
        }else if(obj == exitItem){
            System.out.println("退出游戏");
            System.exit(0);
        }else if(obj == aboutItem){
            System.out.println("关于我们");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //长按a查看完整图片
        if(code==65){
            //清空当前页面
            getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            getContentPane().add(all);
            //添加背景图片

            ImageIcon background = new ImageIcon("../PuzzleGame/image/background.png");
            JLabel backgroundLabel = new JLabel(background);
            backgroundLabel.setBounds(40, 40, background.getIconWidth(), background.getIconHeight());
            getContentPane().add(backgroundLabel);

            //刷新页面
            getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        //对上下左右进行判断
        //定义上下左右的常量
        final int LEFT_KEY = 37;
        final int UP_KEY = 38;
        final int RIGHT_KEY = 39;
        final int DOWN_KEY = 40;
        final int ALL_KEY = 65;
        final int WIN_KEY = 87;
        int code = e.getKeyCode();
        switch (code) {
            case LEFT_KEY -> {
                //将空白块右边的图片向左移动
                System.out.println("left");
                if(blankY+1<data[0].length) {
                    //交换图片位置索引
                    data[blankX][blankY] = data[blankX][blankY+1];
                    data[blankX][blankY+1] = 0;
                    blankY++;
                    //步数加1
                    step++;
                    //重新加载图片
                    InitImage();
                }
            }
            case UP_KEY -> {
                System.out.println("up");
                if(blankX+1<data[0].length) {
                    //交换图片位置索引
                    data[blankX][blankY] = data[blankX+1][blankY];
                    data[blankX+1][blankY] = 0;
                    blankX++;
                    //步数加1
                    step++;
                    //重新加载图片
                    InitImage();
                }
            }
            case RIGHT_KEY -> {
                System.out.println("right");
                if(blankY-1>=0) {
                    //交换图片位置索引
                    data[blankX][blankY] = data[blankX][blankY-1];
                    data[blankX][blankY-1] = 0;
                    blankY--;
                    //步数加1
                    step++;
                    //重新加载图片
                    InitImage();
                }
            }
            case DOWN_KEY -> {
                System.out.println("down");
                if(blankX-1>=0) {
                    //交换图片位置索引
                    data[blankX][blankY] = data[blankX-1][blankY];
                    data[blankX-1][blankY] = 0;
                    blankX--;
                    //步数加1
                    step++;
                    //重新加载图片
                    InitImage();
                }
            }
            case ALL_KEY -> {
                InitImage();
            }
            case WIN_KEY -> {
                data = new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,0}
                };
                InitImage();
            }
        }
    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
