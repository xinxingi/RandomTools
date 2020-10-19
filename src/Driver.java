import javax.swing.*;


public class Driver {
    public static boolean black = false;

    public static void main(String[] args){

        // 主窗体
        JFrame f = new JFrame("若泽数据Random Tools");
        // 主窗体设置大小
        f.setSize(800, 500);
        // 主窗体设置位置
        f.setLocation(200, 200);
        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);



        // 菜单栏
        JMenuBar mb = new JMenuBar();
        // 菜单
        JMenu jm = new JMenu("关于");
        JMenu jmTruant = new JMenu("Truant");

        //主页内容
        Index.Content(f);

        //About
        Bar.About(f, jm);

        //Truant
        Bar.Truant(f, jmTruant);

        // 把菜单加入到菜单栏
        mb.add(jm);
        mb.add(jmTruant);

        // 把菜单栏加入到frame，这里用的是set而非add
        f.setJMenuBar(mb);

        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
    }
}
