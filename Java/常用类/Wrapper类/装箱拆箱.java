package 常用类.Wrapper类;

public class 装箱拆箱 {
    public static void main(String[] args) {
        int a1 = 10;
        Integer integer = new Integer(a1);//装箱：把基本类型转换为相应的Wrapper类
        int a2 = integer.intValue();    //拆箱：把Wrapper类转换为相应的基本类型
        Integer integer1 = 20;    //自动装箱
        int a3 = new Integer(30);   //自动拆箱
    }
}
