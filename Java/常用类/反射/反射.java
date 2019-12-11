package 常用类.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射：指程序运行时加载、使用编译期间完全未知的类；对于一个已加载的类，可以知道这个类的所有属性和方法，对于一个已加载的对象，
 *      能调用它所有的属性和方法；类加载完之后，堆内存中出现一个Class类型的对象，里面含有完整的类的结构信息
 * 同一个类只能被加载一次，只会生成一个Class对象
 * 类、基本数据类型、枚举类型、具有相同元素类型的数组都可以生成Class对象
 */
public class 反射 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Test t = new Test(123,"abcd");
        //Class c = Class.forName("Test");//返回指定类名的Class对象
        Class c1 = Test.class;      //返回该 类 的Class对象
        Class c2 = t.getClass();    //返回该 对象 的Class对象
        System.out.println(c1);     //输出该类所在的位置

        //返回路径和类名
        c1.getName();
        //返回类名
        c1.getSimpleName();

        //获得类中的属性
        Field f1 = c1.getField("i");//通过类中的元素名返回一个Field类型的变量(只能获得public)
        Field f4 = c1.getDeclaredField("s");//通过类中的元素名返回一个Field类型元素
        Field[] f2 = c1.getFields();//获取某个类全部属性(只能获得public)
        Field[] f3 = c1.getDeclaredFields();//获取某个类的全部属性

        //获得类中的方法    同上
        Method m1 = c1.getMethod("setS");//方法没有参数则什么都不写
        Method m2 = c1.getDeclaredMethod("setI",int.class);//第一个参数传入方法名，第二个参数传入方法的参数类型
        Method[] m3 = c1.getMethods();
        Method[] m4 = c1.getDeclaredMethods();

        //获得构造方法    同上
        Constructor cs1 = c1.getConstructor();             //参数为构造方法中的参数类型
        Constructor cs2 = c1.getDeclaredConstructor(int.class,String.class);
        Constructor[] constructors = c1.getConstructors();
        Constructor[] constructors1 = c1.getDeclaredConstructors();

    }
}
class Test {
    private int i = 1;
    String s;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Test(int i, String s) {

        this.i = i;
        this.s = s;
    }

    public Test() {

    }
}
