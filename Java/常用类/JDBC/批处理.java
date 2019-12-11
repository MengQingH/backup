package 常用类.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批处理：batch
 * 批处理时尽量使用Statement，PreparedStatement的预编译空间有限，数据量大时会发生异常
 * 使用：调用addBatch()方法向Statement中添加批处理语句，再调用executeBatch()方法执行
 */
public class 批处理 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = null;
        Statement st = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","123456");

            //批处理需要把事务设置为手动提交
            c.setAutoCommit(false);
            st = c.createStatement();
            for (int i = 0; i < 2000; i++) {
                st.addBatch("insert into users (id,name,password) values ("+i+",'meng"+i+"',123456)");
            }
            st.executeBatch();
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
