package 常用类.Swing包.布局管理;

import javax.swing.*;
import java.awt.*;
/**
 * 容器：用来在框架和组件中添加组件，调用组件的getContentPane方法来获取容器
 *    添加组件：add方法来添加组件，也可以直接调用组件对象的add方法来添加组件
 * 布局管理：用来管理组件在父布局中的位置和大小,每一个容器都有一个默认的布局管理器，但可以使用setLayout方法重新设置
 *    边框布局(BorderLayout)：添加时可以为每一个组件选择一个放置位置，可以选择中部、东部、西部、南部、北部，使用时布局会扩展所有组件的尺寸以填满整个空间
 *          frame.add(component,BorderLayout.SOUTH),也可以直接使用SOUTH字符串
 *     网格布局(GridLayout)：每个单元的带下杨，排列整齐，定义时需要指定行数和列数
 *     流布局(FlowLayout)：组件按自动放在同一行，不够一行会居中，一行不够时，会显示在新的一行
 * 面板：一个小框架，可以放组件并设置布局方式，也可以放入框架中，可以用于在一个布局的一部分中使用另一个框架
 *      面板默认布局为流布局
 */

public class 容器和布局管理 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container c = frame.getContentPane();
        JButton jb1 = new JButton("add");
        frame.add(jb1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
