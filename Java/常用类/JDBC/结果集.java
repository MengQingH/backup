package 常用类.JDBC;

import java.sql.*;

/**
 * 结果集：对数据库操作后返回的结果进行操作
 *
 */
public class 结果集 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","123456");
        String sql = "select * from users where id>?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setObject(1,2);

        ResultSet rs = ps.executeQuery();
        while (rs.next()){                       //next()函数用于判断结果集是否有下一个元组，并把游标转到下一个值
            System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3));
                                        //get数据类型()传入对应的列名或该列的列数获得相应的值(查询时的列序)
        }
        if (rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if (c!=null){
            c.close();
        }
    }
}
