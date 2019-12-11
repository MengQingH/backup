package 常用类.反射;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 1、反射机制带来的性能问题：反射会导致程序变慢，可以使用setAccessible方法提高程序运行速度
 *      setAccessible:启动和禁用安全检查的开关，值为true时可以禁用安全检查，禁用安全检查可以提高效率
 * 2、操作泛型：不能直接通过反射操作泛型，Java中泛型仅仅是给编译器javac使用的，编译完成后，反射就被擦除；
 *              所以需要通过ParameterizedType等几种类型来代表不能被归一到Class类中但又和原始类型其名的类型
 *              ParameterizedType:代表一种参数化的类型
 * ……
 */
public class 操作泛型和注解 {
    public static void main(String[] args) throws NoSuchMethodException {
        //获得指定方法的泛型参数信息
        Method m = demo.class.getDeclaredMethod("test1",Map.class,List.class);
        Type[] t = m.getGenericParameterTypes();
        for (Type paramType:
             t) {
            System.out.println("#"+paramType);
            if(paramType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type genericType:
                     genericTypes) {
                    System.out.println("泛型类型"+genericType);
                }
            }
        }
    }
}
class demo{
    public void test1(Map<String,Test> map, List<Test> list){
        System.out.println("test1");
    }
    public Map<String,Test> test2(){
        System.out.println("test2");
        return null;
    }
}
