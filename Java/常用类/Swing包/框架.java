package 常用类.Swing包;
/**
 * 框架：顶层窗口（没有包含在其他窗口中的窗口）被称为框架
 * 创建：
 *      创建类继承JFrame来创建新窗口
 * 框架定位：
 *      setDefautCloseOperation()设置窗口的关闭方式
 *      setSize(width,height)设置窗口大小
 *      setLocation(x,y)设置窗口位置，窗口左上角的点距父组件上y，左x
 *      setBounds(x,y,width,height)指定窗口位置和大小
 *      setIconImage(Image)设置图标
 *      setResizable()设置标题栏
 *      setResizable(boolean)设置窗口大小是否可以改变
 * 确定适合的框架大小：
 *      创建一个Toolkit类(包含很多与本地有关的类)，调用getScreenSize方法获取窗口大小，返回一个Dimension对象，对象中含有屏幕宽高的属性
 */

import javax.swing.*;
import java.awt.*;

public class 框架 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->   //Swing组件必须有事件分派线程进行配置
        {
            SimpleFrame frame = new SimpleFrame();
        });
    }
}
class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 600;

    public SimpleFrame(){
        super("这是一个框架");

        //获取dimension对象
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        setSize(width/2,height/2);
        setLocationByPlatform(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
