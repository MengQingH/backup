package 常用类.Swing包.事件处理;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 动作：一个动作是一个包含以下内容的对象
 * 命令的说明(一个文本字符串和一个可选图标)
 * 执行命令所需要的参数
 * Action接口中的方法：
 *      void actionPerformed(ActionEvent)要执行的动作
 *      void setEnabled(boolean)设置动作启用或禁用
 *      boolean isEnabled()检查这个动作是否启用
 *      void putValue(String key,Object value)储存动作对象中的名/值
 *      Object getValue(String key)获取动作对象中的值
 * Action是一个接口而不是一个类，实现接口必须实现接口中的所有方法。AbstractAction实现了除actionPerformed方法之外的所有方法和
 * 所有的名/值对
 *      NAME动作名称
 *      SMALL_ICON储存小图标的地方
 *      SHORT_DESCRIPTION图标的简要说明
 */
public class 动作 {
    public static void main(String[] args) {
        Frame f = new Frame("动作");
        f.setVisible(true);
    }
}

class Frame extends JFrame {
    private Panel p;
    public Frame(String name) {
        super(name);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new Panel();
        ColorAction tblue = new ColorAction("blue",Color.BLUE);
        //设置按钮动作时：在新建按钮或菜单项时传入动作对象,构造器会从动作对象中读取标签文本和图标
        JButton blue = new JButton(tblue);
        ColorAction tred = new ColorAction("red",Color.RED);
        JButton red = new JButton(tred);
        p.add(blue);
        p.add(red);

        add(p);
    }
    /**与监听器的不同：父类中含有键值对，构造函数只需要初始化部分键值对，不需要另定义变量
     *      向组件中添加动作时，直接传入动作对象
     */
    class ColorAction extends AbstractAction {
        public ColorAction(String name, Color c) {
            putValue(Action.NAME, name);
            putValue("color", c);
            putValue(Action.SHORT_DESCRIPTION, "set color to" + name.toLowerCase());
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            p.setBackground(c);
        }
    }
}

