1. MyBatis中使用注解sql的方式时，如果sql语句中有外部定义的参数，需要用{}把sql语句扩起来，否则会出错
```java
//错误，结果一直是1
@Select("select count(*) from "+TABLE_NAME)
int countEmp();

@Select({"select count(*) from "+TABLE_NAME})
int countEmp();
```

2. 当在controller方法的参数中使用对象传值的时候，类中要有对应的构造方法

3. 前后端传值的几种情况
    * 如果controller中使用@RequestParam("value")注解，就从前端传来的数据中选择消息头中参数名和value相同的赋值给这个参数。controller参数中使用类自动注入类属性的时候不能用这种方式
    * controller方法中的参数是类的情况，会把请求头中参数名和类中属性名相同的参数自动注入，此时不能使用@RequestParam注解。
    * 使用restful方式：request请求后加上参数：/request/param1/param2，同时在controller方法中接收参数@RequstMapping(/requst/{paramName1}/{paramName2})，方法的参数中用@PathVarible(paramName1)接收参数。

4. mapper中写参数的几种方式：
    * 如果mapper接口中的参数类型是类，可以直接在sql语句中写类中的属性名
    * 如果在mapper接口中的参数使用@Param("param")注解，那sql中就必须使用定义的注解。如果一个类使用了@Param注解，sql中使用类的属性就需要 注解名.属性 的方式，注解和注解名.属性 二者必须同时使用。

5. 乱码:
    * 如果tomcat后台打印信息中文出现乱码，可以设置tomcat conf目录下的logging.properties中的java.util.logging.ConsoleHandler.encoding为UTF-8。
    * 如果System.out.println输出乱码，那么为jvm编码的问题。jvm启动时如果不设置编码会按照系统默认编码来启动，系统默认的编码为GBK，而代码的默认编码为UTF-8，就会出现乱码，可以把tomcat配置界面的vm设置为-Dfile.encoding=UTF-8。