package 常用类.Swing包;

import javax.swing.*;
import java.awt.*;

/**
 * 文本输入框：分为以下三种类型，
 *     文本域(JTextField)：接收单行文本的输入
 *     文本区(JTextArea)；可接收多行文本的输入
 *     密码文本(JPassword)：只能接收单行文本，但不会显示
 * 方法：
 *     String getText()获取文本
 *     void setText()设置文本
 *     void setEditable()设置是否可被编辑
 *     boolean isEditable()设置文本是否可被编辑
 *
 *     getPassword()返回密码，密码文本的方法
 * 标签：容纳文本的容器，用来显示内容。可以使用标签类中的量指定对齐方式，LEFT,RIGHT,NORTH,EAST
 */
public class 文本输入 {
    public static void main(String[] args) {
        JFrame j = new JFrame();
        Panel p = new Panel();
        j.add(p);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField t = new JTextField("Default Input",10);
        p.add(t);

        j.setVisible(true);
    }
}
