package 常用类.其他常用类;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * 脚本引擎：可以使Java程序通过一套固定的接口与各种脚本引擎交互，从而可以使Java调用各种脚本语言
 * 
 */
public class 脚本引擎 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        /**
         * 通过脚本引擎执行js代码
         */
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();//脚本引擎管理器
        ScriptEngine engine = sem.getEngineByName("javascript");//获得脚本引擎对象，参数为语言名称
        //定义变量，存储到引擎上下文中
        engine.put("a","java and javascript");//变量既可以被Java操作，也可以被脚本操作
        String s = "var user = {name:'mh',age:20};";//字符串中存储javascript代码
        s += "print(user.name);";
        //执行脚本
        engine.eval(s);//执行字符串中的JavaScript代码
        engine.eval("a = 'java'");//通过JavaScript修改上下文中的内容
        System.out.println(engine.get("a"));

        //定义函数
        engine.eval("function add(a,b){var sum = a+b;return sum;}");
        //执行js函数
        Invocable invocable = (Invocable) engine;//调用函数需要把JavaEngine对象转为Invocable接口
        Object o = invocable.invokeFunction("add",new Object[]{5,4});//使用invokeFunction调用函数
        System.out.println(o);

        /**
         * 执行一个js文件
         */
        //执行一个js文件
        URL u = 脚本引擎.class.getClassLoader().getResource("脚本引擎测试.js");
            //getClassLoader()返回一个类加载器； getResource()查找所有给定名称的资源，返回一个URL对象
        FileReader fr = new FileReader(u.getPath());
        engine.eval(fr);
        fr.close();
    }
}
