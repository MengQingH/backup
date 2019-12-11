package 类;

/**
 *
 */
public class 类 {
    public static void main(String[] args) {
        Object1 a = new Object1(2);    //运行时，先执行类加载，同时静态函数和变量初始化
        System.out.println(a.toString());
    }
}
//类和属性：private：只有类本身可以使用，protected：同一包和子类可以调用，默认：同一包中的可以调用，public：所有类都可以调用
class Object1{
    private int i;    //类中的属性一般要设置为private
    private int a = 11;   //在类定义时初始化某属性，可以使所有对象中该属性的值全相同
    private final int fi;  //设置为final的属性必须在构造器中初始化，并且初始化后不可改变值
    private static int i1;   //设置为static的属性和方法在内存中拥有自己的一片空间，该类的所有对象共享这一片空间，调
    private static double PI =  3.14;     // 用时可以使用类名.属性名的方式调用，在类加载时进行初始化

    public Object1(int fi){
        this.fi = fi;
    }

    public Object1(int i,int fi){
        this.fi = fi;
        this.i = i;
    }
    public static int pow1(int a,int b){   //静态方法：不能使用非静态变量
        return (int) Math.pow(a,b);
    }
}