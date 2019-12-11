package 常用类.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务：一组要么同时执行成功，要么同时执行失败的语句，是数据库操作的执行单元
 *      开始：连接数据库，并执行一条DML语句(insert，delete，update)；
 *            前一个事务结束又执行一条DML语句；
 *      结束：执行commit(事务执行成功)或rollback(执行失败，数据回滚到之前的状态)语句；
 *            执行DDL或DCL语句，会默认执行commit语句；
 *            断开与数据库的连接；
 *            执行一条DML语句失败，会执行rollback语句；
 * 特性：原子性：一个事务内的所有操作是一个整体，要么全部成功，要么全部失败；
 *      一致性：事务内的一个操作失败时，所有更改过的数据必须回滚到修改前的状态；
 *      隔离性：数据所处的状态，要么是事务修改它之前的状态，要么是事务修改它之后的状态，没有中间状态
 *      持久性：事务完成后对系统的影响是永久性的
 */
public class 事务 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","123456");

        c.setAutoCommit(false);//jdbc默认自动提交事务

        String sql = "insert into user values(9,f,111)";//执行一个DML语句，事务开始
        PreparedStatement ps = c.prepareStatement(sql);
        ps.execute();

        String sql2 = "insert into user values(7,e,135)";
        PreparedStatement ps2 = c.prepareStatement(sql2);
        ps2.execute();
        c.commit();//commit函数代表事务结束
    }
}
