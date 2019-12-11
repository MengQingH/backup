
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 非静态的工具类
 */
public class SqlUtil2 {
    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;

    //连接数据库参数
    private String url = null;
    private String username = null;
    private String driver = null;
    private String password = null;

    //连接数据库函数
    private void conn() {
        FileInputStream fis = null;
        try {
            Properties p = new Properties();
            fis = new FileInputStream("D:\\JavaProject\\UserManager\\dbinfo.properties");
            p.load(fis);
            url = p.getProperty("url");
            username = p.getProperty("username");
            driver = p.getProperty("driver");
            password = p.getProperty("password");
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SqlUtil2() {
        conn();
    }

    private void close(Connection c, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList excuteQuery2(String sql, String[] para) {
        ArrayList a = new ArrayList<User>();
        try {
            c = DriverManager.getConnection(url, username, password);
            ps = c.prepareStatement(sql);
            if (para != null) {
                for (int i = 0; i < para.length; i++) {
                    ps.setObject(i + 1, para[i]);
                }
            }
            rs = ps.executeQuery();

            //把结果集中的数据封装到一个对象数组中并放入ArrayList
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnNum = rsmd.getColumnCount();
            while (rs.next()){
                Object[] objects = new Object[columnNum];

                for (int i = 0; i < objects.length; i++) {
                    objects[i] = rs.getObject(i+1);
                }
                a.add(objects);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(c,ps,rs);
        }
        return a;
    }

    public int excuteUpdate(String sql,String[] para){
        int num = 0;
        try {
            c = DriverManager.getConnection(url, username, password);
            ps = c.prepareStatement(sql);
            if (para!=null){
                for (int i = 0; i < para.length; i++) {
                    ps.setObject(i+1,para[i]);
                }
            }
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(c,ps,rs);
        }
        return num;
    }


}
