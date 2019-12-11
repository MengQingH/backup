package 常用类.异常;

public class 异常 {
    public static void main(String[] args) {
        try{                     //可能出错的语句   一般情况产生错误后后面的语句不执行
            int b=1/0;
        }catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
            //return;    //若return，则不会继续执行下面的catch语句
        }catch(Exception e){      //产生一个异常类
            System.out.println("Exception");  //输出异常类
            System.exit(5);
        } finally{              //无论产生不产生异常都会执行finally中的语句
            System.out.println("finally");
        }
    }
}
/*NullPointerException - 空指针引用异常
ClassCastException - 类型强制转换异常
IllegalArgumentException - 传递非法参数异常
ArithmeticException - 算术运算异常
ArrayStoreException - 向数组中存放与声明类型不兼容对象异常
IndexOutOfBoundsException - 下标越界异常
NegativeArraySizeException - 创建一个大小为负数的数组错误异常
NumberFormatException - 数字格式异常
SecurityException - 安全异常
UnsupportedOperationException - 不支持的操作异常*/