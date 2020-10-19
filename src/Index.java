import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Index {
    public static void Content(JFrame f){

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

                if(Driver.black) person = Integer.parseInt(Utils.getProperties("Black"));

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


        f.add(lName);
        f.add(tfName);
        f.add(lName1);
        f.add(tfName1);

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
                if (tfName.getText().isEmpty() || Integer.parseInt(tfName.getText()) == 0) {
                    System.out.println("你没有输入数据，无需变更");
                    JOptionPane.showMessageDialog(f,"莫要不输入数据或者为0");
                }else {
                    Utils.setProperties("maxPerson", tfName.getText());
                }

                if (tfName1.getText().isEmpty()) {
                    System.out.println("你没有输入数据，无需变更");
                }else {
                    Utils.setProperties("throwPerson", tfName1.getText() + "," + Utils.getProperties("throwPerson"));

                }

            }

        });

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
                    Driver.black = true;
                }
                if (s.contains("-")) {
                    Driver.black = false;
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

    }
}
