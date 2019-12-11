package 常用类.Swing包;

import javax.swing.*;
import java.awt.*;

/**
 * 菜单：创建菜单栏对象
 *      创建菜单对象
 *      把菜单对象加到菜单栏中
 *      创建菜单项，分隔符和子菜单
 */
public class 菜单 {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setLayout(new FlowLayout());
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("菜单1");
        JMenu m2 = new JMenu("菜单2");
        JMenuItem mi1 = new JMenuItem("菜单项1");
        JMenuItem mi2 = new JMenuItem("菜单项2");
        m1.add(mi1);
        m2.add(mi2);
        m1.addSeparator();
        m2.addSeparator();
        mb.add(m1);
        mb.add(m2);

        f.setJMenuBar(mb);
        f.setVisible(true);
    }
}
