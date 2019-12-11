package 常用类.JDBC;

import java.sql.*;

/**
 * 注：访问完数据库之后需要关闭，先关闭后建立的对象：ResultSet-->Statement-->Connection
 * 访问数据库流程：
 *      加载JDBC驱动程序(driver接口)(由数据库公司提供，要连接特定的数据库，必须装载指定厂商的接口)
 *          MySQL:Class.forName("com.mysql.jdbc.Driver")    Oracle:Class.forName(Oracle.jdbc.driver.OracleDriver)
 *      建立与数据库的连接(DriverManager)
 *          使用DriverManager的getConnection方法获得Connection连接：
 *          mysql:Connection c = DriverManager.getConnection("jdbc:mysql://host:port/database","user","password")
 *              (url最后需要加上时区 ?serverTimezone=GMT%2B8，否则报错The server time zone value *** is unrecognized)
 *          oracle:Connection c = DriverManager.getConnection("jdbc:oracle:thin:@host:port:database","user","password")
 *      发送SQL语句(Connection接口，与特定数据库连接，执行SQL语句并返回结果)
 *          Statement接口：
 *              用于执行SQL语句并返回他所生成结果的对象
 *              三种Statement类：
 *                  Statement：由createStatement创建，用于发送简单的SQL语句(不带参数)；
 *                  PreparedStatement：继承自Statement接口，由prepareStatement(sql)创建，用于发送含有一个或多个输入参数的sql语句，
 *                          效率高，并且可以防止SQL注入，所以常用PreparedStatement；
 *                  CallableStatement：继承自PreparedStatement，由prePareCall创建，用于调用储存过程；
 *              常用的Statement方法：
 *                  execute()：运行语句，返回是否有结果集；
 *                  executeQuery()：运行select语句，返回ResultSet结果集；(常用)
 *                  executeUpdate()：运行insert、update、delete操作，返回更新的行数；(常用)
 *      得到查询结果(ResultSet)
 */
public class 访问数据库 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");

        //建立连接
        String s = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        long start = System.currentTimeMillis();
        Connection c = DriverManager.getConnection(s,"root","123456");
        System.out.println(c);
        long end = System.currentTimeMillis();
        //System.out.println("耗时："+(end-start));//建立连接比较耗时

        /**
         * //使用Statement发送sql语句
         Statement st = c.createStatement();
         String sql = "insert into users values(4,'c',444,now())";
         st.execute(sql);
         //使用外部字符串
         String name = "m";
         String sql1 = "insert into users values(5,'"+name+"',444,now())";//使用连接符+把外界字符串连接到sql语句中
         st.execute(sql1);
         //sql注入
         String id = "5 or true";
         String sql2 = "delete from users where id = "+id;//如果外界字符串不规范，就可能造成数据库信息丢失
         st.execute(sql2);
         */
        //使用PreparedStatement发送sql语句
        String sql = "insert into users(id,name,reg_time) values(?,?,?)";//？为占位符，代表一个不确定的参数
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,9);//给占位符添加值，参数索引为？从1开始算
        ps.setString(2,"x");
        //ps.setObject(1,9);
        //ps.setObject(2,"x");同上两行代码
        ps.setTime(3,new Time(System.currentTimeMillis()));
        //ps.setDate(3,new Date(System.currentTimeMillis()));  同上行代码
        ps.execute();

        if(ps!=null){
            ps.close();
        }
        if (c!=null){
            c.close();
        }
    }
}
