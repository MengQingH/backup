package 常用类.Swing包.事件处理;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 监听器是一个实现了监听器接口的类的对象，事件源是一个能够注册监听器对象并发送给所有注册的监听器
 * 事件发生时，事件源将时间对象传递给所有注册的监听器，监听器对象将利用事件对象中的信息决定如何对事件作出回应
 *
 * 监听器：为了实现监听器接口，监听器类必须有actionPerformed方法，该方法接收一个ActionEvent对象参数
 */
public class 监听器 {
    public static void main(String[] args) {
//        SimpleFrame jf = new SimpleFrame("框架");
//        jf.setVisible(true);

        //一个监听器创建多个类的方式并不常见，常见情况为每个监听器执行单独的动作，这种情况下，只需要一个lambda表达式
        JFrame j = new JFrame();
        Panel p = new Panel();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(900,600);
        j.add(p);
        JButton red = new JButton("Red");
        red.addActionListener(event->p.setBackground(Color.RED));//直接使用框架设置背景失败，存疑
        p.add(red);
        j.setVisible(true);
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 600;
    private Panel buttonPanel;

    public SimpleFrame(String name){
        super(name);

        //获取dimension对象
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        //设置框架属性
        setSize(width/2,height/2);
        setLocationByPlatform(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建按钮
        buttonPanel = new Panel();
        JButton yellow = new JButton("Yellow");
        ColorAction ty = new ColorAction(Color.YELLOW);//定义事件监听器的对象
        yellow.addActionListener(ty);//给按钮添加事件监听器
        JButton blue = new JButton("Blue");
        ColorAction tb = new ColorAction(Color.BLUE);
        blue.addActionListener(tb);
        buttonPanel.add(yellow);
        buttonPanel.add(blue);

        add(buttonPanel);
    }

    class ColorAction implements ActionListener{
        private Color bg;

        public ColorAction(Color bg) {
            this.bg = bg;
        }

        //事件监听器的行为，检测到事件后执行该函数
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(bg);
        }
    }
}
