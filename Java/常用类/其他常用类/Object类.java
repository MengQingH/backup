package 常用类.其他常用类;

/**
 * Object为所有类的父类,所有类中都有Object类中定义的方法
 */
public class Object类 {
    public static void main(String[] args) {
        Object oj = new Object();
        System.out.println(oj);  //输出对象时，默认输出对象的toString()方法
        oj.toString();//返回类路径.类名+@+对象的哈希码
        oj.getClass();//返回该类的Class类的对象
        oj.hashCode();//对象使用时，返回该类的哈希码（哈希码：代表了对象的特征，根据对象的地址生成，唯一）
        oj.equals(oj);//判断两个对象是否相等，相当于“==”，只判断在内存中是否相等，即两个对象引用是否指向同一个对象
    }
}