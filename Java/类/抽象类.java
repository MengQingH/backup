package 类;

/**
 * 抽象类：含有抽象方法的类称为抽象类
 *      抽象类还可以包含具体函数和方法
 *      抽象类不能实例化，但是可以通过向上转型建立抽象类对象
 * 抽象方法：用abstract声明的方法为抽象方法，抽象方法不能声明方法体
 */
public class 抽象类 {
    public static void main(String[] args) {
        AbObject abObject;   //抽象类不能实例化，但是可以定义对象变量
    }
}
abstract class AbObject{  //包含抽象方法的类必须被声明为抽象类，抽象类还可以包含具体数据和方法，但最好不要
    int i;
    public abstract int plus();//抽象方法不能声明方法体，用abstract声明抽象方法

}