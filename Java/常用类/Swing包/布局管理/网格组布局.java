package 常用类.Swing包.布局管理;

import javax.swing.*;
import java.awt.*;

/**
 * 网格组布局：没有任何限制的网格布局，行和列的尺寸都可以改变
 *     建立一个GridBagLayout对象，不需要指定行数和列数
 *     把该对象设置成布局管理器
 *     为每一个组件建立一个GridBagConstraints对象，设置每一个GridBagConstraints的域以便指出组件在网格中的布局方案
 *     通过下面的调用添加组件的约束
 * 约束：
 *      gridx,gridy,gridwidth,gridheight：定义了组件在网格中的位置，xy指定组件左上角的行列位置，width height指定饿了组件占的行列数
 *      增量域weightx,weighty：组件放大缩小时，长宽变化的尺寸
 *      fill：如果不希望组件拉伸至整个区域，需要设置fill约束，他有四个有效值：GridBagConstraints.NONE\HORIZONTAL\VERTICAL\BOTH
 *      anchor:如果组件没有填充整个区域，可以通过设置author域指定其位置，有效值为GridBagConstraints.CENTER\NORTH\NORTHEAST\EAST
 *
 */
public class 网格组布局 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(900,600);

        GridBagLayout layout = new GridBagLayout();
        Panel panel = new Panel();
        panel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 100;
        constraints.weighty = 100;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        panel.add(new JButton("Button"),constraints);
        jFrame.add(panel);

        jFrame.setVisible(true);
    }
}
