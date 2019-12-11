package 常用类.其他常用类;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态编译：类似远程运行别处的Java代码，使用JavaCompiler进行动态编译
 *          使用：新建一个JavaCompiler对象，调用Compiler的run方法，run(输入流 为编译器提供参数信息，输出流 得到Java编译器的输出信息，
 *          输出流 得到错误信息，可变参数 传入一个或多个Java源文件)  返回值0表示编译成功，非0表示便宜失败
 * 动态运行：
 */
public class 动态编译 {
    public static void main(String[] args) {
        //动态编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"D:/HolleWorld.java");
        System.out.println(result == 0?"编译成功":"编译失败");

        //使用反射运行编译好的类
        try {
            URL[] urls = new URL[]{new URL("file:/"+"D:/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HolleWorld");
            //调用加载类的main方法
            Method m = c.getDeclaredMethod("main",String[].class);
            m.invoke(null,(Object)new String[]{});
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
