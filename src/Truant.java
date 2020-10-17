import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Truant {
    public static void TruantJPanel(JFrame f, JMenu jmTruant){

        //Truant 菜单项
        JMenuItem jiTruantAdd = new JMenuItem("Add");
        JMenuItem jiTruantList = new JMenuItem("List");
        JMenuItem jiTruantRemove = new JMenuItem("Remove");

        //添加到Truant中
        jmTruant.add(jiTruantAdd);
        jmTruant.add(jiTruantList);
        jmTruant.add(jiTruantRemove);

        // 给菜单项jiTruantList 增加监听
        jiTruantList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f,Utils.getProperties("Truant").split(","));
            }
        });

        // 给菜单项jiTruantAdd 增加监听
        jiTruantAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputAdd = JOptionPane.showInputDialog("请输入:");

                if (inputAdd.isEmpty()) {
                    System.out.println("你没有输入数据，无需变更");
                }else {
                    Utils.setProperties("Truant", inputAdd + "," + Utils.getProperties("Truant"));
                    JOptionPane.showMessageDialog(f,"新增成功！");
                }

            }
        });

        // 给菜单项jiTruantRemove 增加监听
        jiTruantRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputAdd = JOptionPane.showInputDialog("请输入:");
                if (inputAdd.isEmpty()) {
                    System.out.println("你没有输入数据，无需变更");
                }else {
                    //拿到配置文件
                    String Truant = Utils.getProperties("Truant");
                    //切割，转list
                    String[] TruantSplit = Truant.split(",");
                    List<String> TruantList = Arrays.asList(TruantSplit);
                    List<String> arrList = new ArrayList<>(TruantList);

                    //删除
                    arrList.remove(inputAdd);
                    Utils.setProperties("Truant", String.join("," ,arrList));

                    JOptionPane.showMessageDialog(f,"删除成功！");
                }

            }
        });



    }
}
