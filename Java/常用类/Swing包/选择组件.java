package 常用类.Swing包;

import javax.swing.*;
import java.awt.*;

/**
 * 复选框
 * 组合框
 */
public class 选择组件 {
    public static void main(String[] args) {
        Frame f = new Frame();
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        f.add(p1,BorderLayout.WEST);
        f.add(p2,BorderLayout.EAST);

        //复选框
        //创建选择项
        JCheckBox jc1 = new JCheckBox("选择1");
        JCheckBox jc2 = new JCheckBox("选择2");
        //为选择项添加监听器
        jc1.addActionListener(e -> p1.setBackground(Color.BLUE));
        jc2.addActionListener(e -> p2.setBackground(Color.red));
        p1.add(jc1);
        p1.add(jc2);

        //组合框(下拉框)
        //创建组合框，为一个泛型类
        JComboBox<String> comboBox = new JComboBox<>();
        //向组合框中添加选择项
        comboBox.addItem("选项1");
        comboBox.addItem("选项2");
        JLabel label = new JLabel("123");
        comboBox.addActionListener(e -> label.setText(comboBox.getSelectedItem().toString()));
        p1.add(comboBox);
        p1.add(label);

        f.setVisible(true);
    }
}
