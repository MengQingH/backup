package 类;

/**
 * 内部类：在一个类内部定义的类
 *         内部类可以使用外部类的方法和属性，在外部类中地位相当于方法：当一个外部类对象创建一个内部类对象时，内部类对象会捕获一个
 *              指向外类的引用，调用外部类成员时，通过引用来调用
 *         不能在内部类中定义静态属性和方法
 *         .this语法：内部类中生成外部类对象时，使用 外部类.this 生成
 *         .new语法：定义和创建内部类时用 外部类名.内部类名 = 外部类对象.new 内部类名
 * 作用：实现隐藏，实现多重继承
 * 静态内部类：嵌套类，不需要内部类对象和外部类之间有联系
 *            不能使用外部类的成员变量和方法，可以只用外部类的静态成员
 *            创建静态内部类不需要像普通内部类使用 对象.new 创建
 */
public class 内部类 {
    public static void main(String[] args) {
        InnerClass outer = new InnerClass();
        InnerClass.Inner inner = outer.new Inner();//定义内部类用外类名.内部类名，创建时用外部类对象new 内部类名
        InnerClass.sInner si = new InnerClass.sInner();//创建静态内部类时，不需要.new语法
        outer.test();
        inner.display();

        new InnerClass().test();//匿名类

    }
}
class InnerClass{
    private int a = 1;
    static int P = 5;

    /**
     * 内部类
     */
    class Inner {
        private int b;
        //内部类可以直接访问外类的成员变量
        public void display() {
            System.out.println(a);
        }
    }

    /**
     * 通过定义方法调用定义的内部类
     */
    void test(){
        Inner inner = new Inner();//建立内部类对象2
        inner.display();
    }

    /**
     * 静态内部类(嵌套类)：不需要内部类对象和外部类之间有联系
     */
    static class sInner{
        static int s = 123;
        void testP(){
            System.out.println(P);
        }
    }

    /**
     * 匿名内部类
     */


}
