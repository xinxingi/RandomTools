import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Driver {
    private static boolean black = false;

    public static void main(String[] args){
        /**
         * 主窗口
         */
        // 主窗体
        JFrame f = new JFrame("若泽数据Random Tools");
        // 主窗体设置大小
        f.setSize(800, 500);
        // 主窗体设置位置
        f.setLocation(200, 200);
        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);

        /**
         * 按钮等组件
         */
        // 按钮组件
        JButton b = new JButton("点击开始抽取小倒霉蛋");
        // 同时设置组件的大小和位置
        b.setBounds(280, 50, 200, 80);
        // 把按钮加入到主窗体中
        f.add(b);
        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {

            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            @Override
            public void actionPerformed(ActionEvent e) {
                int person = 0;

                try {
                    person = RandomMain.getPerson();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                if(black) person = Integer.parseInt(Utils.getProperties("Black"));

                JOptionPane.showMessageDialog(f,person,"恭喜这个逼",JOptionPane.QUESTION_MESSAGE);
            }

        });


        //人数文本
        JLabel lName = new JLabel("人数:");
        lName.setBounds(100, 300, 200, 80);
        lName.setFont(new Font("宋体", Font.PLAIN, 20));

        // 人数输入框
        JTextField tfName = new JTextField();
        tfName.setBounds(150, 325, 50, 30);
        tfName.setPreferredSize(new Dimension(50, 20));

        //白名单文本
        JLabel lName1 = new JLabel("白名单:");
        tfName.setText(Utils.getProperties("maxPerson"));
        lName1.setBounds(340, 300, 200, 80);
        lName1.setFont(new Font("宋体", Font.PLAIN, 20));

        // 白名单输入框
        JTextField tfName1 = new JTextField();
        tfName1.setBounds(420, 325, 200, 30);
        tfName1.setPreferredSize(new Dimension(50, 20));

        //人数文本
//        JLabel CurrentRange = new JLabel("当前人数范围:"+Utils.getProperties("maxPerson"));
//        CurrentRange.setBounds(30, 5, 200, 80);
//        CurrentRange.setFont(new Font("宋体", Font.PLAIN, 25));
//        CurrentRange.setForeground(new Color(255, 48, 48));

        f.add(lName);
        f.add(tfName);
        f.add(lName1);
        f.add(tfName1);
//        f.add(CurrentRange);

        // 按钮组件
        JButton c = new JButton("确定");
        // 同时设置组件的大小和位置
        c.setBounds(600, 380, 100, 30);
        // 把按钮加入到主窗体中
        f.add(c);
        // 给按钮 增加 监听
        c.addActionListener(new ActionListener() {

            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            @Override
            public void actionPerformed(ActionEvent e){
                if (tfName.getText().isEmpty()) {
                    System.out.println("你没有输入数据，无需变更");
                }else {
                    Utils.setProperties("maxPerson", tfName.getText());
                }

                if (tfName1.getText().isEmpty()) {
                    System.out.println("你没有输入数据，无需变更");
                }else {
                    Utils.setProperties("throwPerson", tfName1.getText() + "," + Utils.getProperties("throwPerson"));

                }


                //重启


            }

        });

        // 菜单栏
        JMenuBar mb = new JMenuBar();
        // 菜单
        JMenu jm = new JMenu("关于");
        //菜单项
        JMenuItem ji = new JMenuItem("白名单列表");
        // 给按钮 增加 监听
        ji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f,Utils.getProperties("throwPerson").split(","));
            }
        });

        jm.add(ji);
        // 把菜单加入到菜单栏
        mb.add(jm);
        // 把菜单栏加入到frame，这里用的是set而非add
        f.setJMenuBar(mb);

        /**
         * 键盘事件
         */
        // 增加键盘监听
        b.addKeyListener(new KeyListener() {
            //https://blog.csdn.net/zhaozhbcn/article/details/38852583
            // 键被弹起
            public void keyReleased(KeyEvent e) {
                String s = new String(new char[]{e.getKeyChar()});
                if (s.contains("+")) {
                    black = true;
                }
                if (s.contains("-")) {
                    black = false;
                }

            }

            //键被按下
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {

            }
        });

        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
    }
}
