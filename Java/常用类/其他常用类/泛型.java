package 常用类.其他常用类;

/**
 * 泛型：把数据类型作为参数，可以在类、接口和方法中，分别称为泛型类、泛型接口、泛型方法
 */
public class 泛型 {
    public static void main(String[] args) {
        //泛型类的初始化，类型参数必须为类，不能为基本数据类型
        //传入的实参必须与类型参数类型相同
        ClassName c1 = new ClassName<Integer,String>(5);
        ClassName c2 = new ClassName<String,Boolean>("a");
        ClassName c3 = new ClassName(true);    //初始化时也可以不传入类型参数，则实参可以为任意类型

        /**
         * 泛型通配符：用？代表未知类型
         */
        ClassName<?,?> a = new ClassName<>(4);
    }

    /**
     * 泛型方法
     * <>中定义类型参数表明此方法是泛型方法
     * 泛型类中的使用了泛型的成员方法并不是泛型方法
     */
    public <F> F getF(){
        return null;
    }
}
/**
 * 泛型类：定义类名时在类名后加<>，其中放上类型参数
 * 静态方法无法访问类上定义的泛型
 */
class ClassName<T,Y>{
    private T t;
    private Y y;

    ClassName(T t){
        this.t = t;
    }
}

/**
 * 泛型接口
 * @param <M>
 */
interface inter<M>{
    public M get();
}
class Class1<M> implements inter{//未传入泛型实参时，在声明类的时候，需将泛型的声明也一起加到类中
    public M get(){
        return null;
    }
}
class Class2 implements inter<String>{//传入泛型实参时，所有使用泛型的地方都要替换成传入的实参类型
    @Override
    public String get() {
        return null;
    }
}