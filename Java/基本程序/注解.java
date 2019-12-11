package 基本程序;

public class 注解 extends Object{
    public static void main(String[] args) {
        test001();
    }

    @Override                 //Override表明是重写的父类的方法
    public String toString() {
        return "";
    }

    @Deprecated             //表示不建议使用，通常表示很危险或有更好的选择
    public static void test001(){

    }

    @SuppressWarnings("all")    //消除方法中的警告
    public static void test002(){
    }
}
