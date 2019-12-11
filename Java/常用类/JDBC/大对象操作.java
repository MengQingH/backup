package 常用类.JDBC;

import java.io.*;
import java.sql.*;

/**
 * CLOB:
 *      用于储存大量的文本数据，通常以流的形式处理
 *      常用类型：TINYTEXT,TEXT,MEDIUMTEXT,LONGTEXT
 * BLOB:
 *      用于储存大量的二进制数据，以流的形式处理
 *      常用类型：TINYBLOB,BLOB,MEDIUMBLOB,LONGBLOB
 */
public class 大对象操作 {
    public static void main(String[] args) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8","root","123456");

            //向数据库中插入大数据
            ps = c.prepareStatement("insert into users(name,myInfo) VALUES (?,?)");
            ps.setObject(1,"mh1");
            //把文本文件输入数据库中,需要传入"字符"流
            //ps.setClob(2,new FileReader("D:\\IDEAchengxu\\IOfrom.txt"));
            //输入二进制数据，需要传入"字节"流
            //ps.setBlob(2, new FileInputStream("D:\\IDEAchengxu\\IOfrom.txt"));
            //把字符串输出到数据库中
            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aabbcc".getBytes()))));
                                                                        
            //ps.execute();

            //读取数据库中的大数据
            ps1 = c.prepareSatement("select * from users where name = ?");
            ps1.setObject(1,"mh");
            rs = ps1.executeQuery();
            while (rs.next()){
                Clob cl = rs.getClob("name");
                Reader r = cl.getCharacterStream();
                int i = 0;
                while ((i = r.read())!=-1){
                    System.out.print((char)i);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
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
