package 常用类.JDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * JDBC中表示时间的类型：
 * java.sql.Date:代表年月日；
 * java.sql.Time:代表时分秒；
 * java.sql.Timestamp:代表年月日时分秒
 */
public class 时间处理 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8", "root", "123456");

        /**
         * 生成并设置时间
         */
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Time t = new Time(System.currentTimeMillis());
        java.sql.Date d = new java.sql.Date(System.currentTimeMillis());//需要传入一个数值代表当前时间经过的毫秒数
        PreparedStatement ps = c.prepareStatement("insert into users values(10,'孟辉',123444,?)");
        ps.setObject(1, d);

        //ps.execute();

        //生成随机时间
        int rand = new Random().nextInt(1000000);
        for (int i = 0; i < 5; i++) {
            ps = c.prepareStatement("insert into users values(?,?,?,?)");
            ps.setObject(1, i + 20);
            ps.setObject(2, "meng" + (i + 20));
            ps.setObject(3, 12345);
            ps.setObject(4, new Timestamp(System.currentTimeMillis() - rand));
            ps.execute();
        }

        /**
         * 查询指定时间段内的内容
         */
        PreparedStatement ps1 = c.prepareStatement("select * from users where reg_time>? and reg_time<?");
        ps1.setObject(1, new java.sql.Date(strdate("2018.5.3")));
        ps1.setObject(2, new java.sql.Date(strdate("2018.5.5")));
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getObject(4));
        }

    }
    public static Long strdate(String datestr) throws ParseException {
        DateFormat df = new SimpleDateFormat("y.M.d");
        return df.parse(datestr).getTime();
    }
}


