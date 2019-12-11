package 常用类.Wrapper类;


public class Wrapper类方法 {
    public static void main(String[] args) {
        Integer integer;
        integer = Integer.valueOf(12);         //一个参数时把参数作为封装类的值(参数可以为数字或字符串)
        integer = Integer.valueOf("1234",5);  //第一个对象为数据类型的字符串，第二个对象为前面数据的进制，函数会
                                                             // 把数据转换为十进制并赋值给Wrapper类
        System.out.println(integer);
        //valueOf()，静态方法：返回一个Wrapper类对象，参数为对象的值，调用时用类名.valueOf()；

        int i = integer.intValue();
        System.out.println(i);
        //XXXValue()，拆箱函数，把Wrapper类的值赋给变量

        int a = Integer.parseInt("15");
        //parseXXX()，静态函数，参数为一个数据类型的字符串，返回值为XXX，把字符串变为基本数据类型并返回；若字符串中有除数字以外的其他类型则报错
    }
}
