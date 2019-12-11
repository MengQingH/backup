package 常用类.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射动态调用构造器、方法、属性
 */
public class 调用 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c = Test.class;

        //通过反射调用构造方法构造对象
        Test test = (Test) c.newInstance();//可以通过newInstance()方法新建一个对象(需要强转)(调用了Test的无参构造方法)
                                              //无无参构造方法会报错
        Constructor<Test> ct = c.getDeclaredConstructor(int.class,String.class);//先获得某一个有参的构造器的Constructor对象
        Test test1 = ct.newInstance(1,"a");      //再调用该对象的newInstance方法传入构造方法的参数创建一个对象
        System.out.println(test1.getI()+"  "+test1.getS());

        //通过反射调用普通方法
        Test test2 = (Test) c.newInstance();
        //test2.setI(5);    //普通调用
        Method method = c.getDeclaredMethod("setI",int.class);//Method变量即代表这个方法
        method.invoke(test2,5);     //通过反射调用普通方法；第一个参数为操作的对象

        //通过反射操作属性
        Test test3 = (Test) c.newInstance();
        Field field = c.getDeclaredField("i");
        field.setAccessible(true);//类中的私有属性需要加此条语句才能进行操作，表明这个属性不需要做安全检查，可以直接访问
                                    //私有方法也可以通过此方法调用
        field.set(test3,6);//通过反射直接写属性的值；第一个参数为操作的对象，第二个参数为要设的值;
        System.out.println(test3.getI());
        System.out.println(field.get(test3));//通过反射直接读属性，同上条语句
    }
}
