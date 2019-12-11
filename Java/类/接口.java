package 类;

/**
 * 接口：
 *      接口中不能定义非抽象函数，接口中的函数不声明修饰符则默认为abstract、public
 *      接口中不能定义属性，但是可以定义常量,默认为static、final，常量也会被类继承
 *      接口不能实例化，可以通过向上转型建立对象
 * 接口之间也可以实现继承：
 */
public class 接口 {
    public static void main(String[] args) {
        inter1 i;                 //接口不能实例化，但可以声明变量
        Object2 o = new Object2();
        i = o;
        i.compareTo();
        System.out.println(i.PI);
    }
}
interface inter1{
    double PI = 3.14;
    void compareTo();//接口中的方法不能定义方法体，只能且必须在声明接口的类中定义
}
/**
 * 接口之间实现继承
 */
interface inter2 extends inter1{
    //void compareTo(); 尽量避免不同继承接口时不同的接口中定义相同的方法
}

class Object2 implements inter2{
    public void compareTo(){
        System.out.println("compareTo");
    }
}
