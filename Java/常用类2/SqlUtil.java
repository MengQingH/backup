
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 数据库工具类
 */
public class SqlUtil {
    //连接数据库参数
    private static String url = "";
    private static String username = "";
    private static String driver = "";
    private static String password = "";

    private static FileInputStream fis = null;

    static {
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

    /**
     * 获取Connection对象
     * @return Connection
     */
    private static Connection getConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     * 关闭连接
     * @param c 
     * @param ps
     * @param rs
     */
    public static void close(Connection c,PreparedStatement ps,ResultSet rs) {
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

    
    /**
     * 数据库查询函数
     * @param sql:查询语句
     * @param para:字符串数组，存放查询参数
     * @return 返回一个ArrayList对象，包含存放结果集信息的Object数组
     */
    public static ArrayList select(String sql, String[] para) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList a = new ArrayList();
        try {
            c = getConnection();
            ps = c.prepareStatement(sql);
            if (para != null) {
                for (int i = 0; i < para.length; i++) {
                    ps.setObject(i + 1, para[i]);
                }
            }
            rs = ps.executeQuery();
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


    /**
     * 数据库更新函数
     * @param sql:sql语句
     * @param para:String[]，保存参数
     * @return 返回更新的行数
     */
    public static int update(String sql,String[] para){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            c = getConnection();
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