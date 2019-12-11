package 常用类.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基本思想：表结构和类对应；表中字段和类的属性对应；表中记录和对象对应
 *          让javabean的属性名和类型尽量和数据库保持一致
 *          一条记录对应一个对象，把这些查询到的对象放到容器中(List,Set,Map)
 * 使用Object[]封装一条记录
 * 使用Map封装一条记录
 * 将表中的一条记录封装到JavaBean中
 *
 * 使用List<Object>存储多条记录
 */
public class ORM原理和JDBC类的封装 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getCon();

            ps = con.prepareStatement("SELECT empname,salary,age from emp");
            rs = ps.executeQuery();

            //把查到的数据放入Object数组中
            Object []obj = new Object[3];
            while (rs.next()){
                obj[0] = rs.getObject(1);
                obj[1] = rs.getObject(2);
                obj[3] = rs.getObject(3);
            }
            //把Object中的数据放入List中
            List<Object> l = new ArrayList<>();
            l.add(obj);

            //用Map封装一条记录
            Map<String,Object> m = new HashMap<>();
            m.put("empname",rs.getObject(1));
            m.put("salery",rs.getObject(2));
            m.put("age",rs.getObject(3));
            //把Map中的数据放入List中
            List<Map<String,Object>> l1 = new ArrayList<>();
            l1.add(m);
            //把Map中的数据放入另一个Map中
            Map<String,Map<String,Object>> mapMap = new HashMap<>();
            mapMap.put(rs.getString(1),m);

            //将表中的一条记录封装到JavaBean中
            Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));


        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clo(con,ps,rs);
        }

    }
    //把获取连接的方法封装为函数
    public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT%2B8","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void clo(Connection c,PreparedStatement ps,ResultSet rs){
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
    static class Emp{
        private int id;
        private String empname;
        private int age;
        private double salary;
        private java.sql.Date birthday;
        private int deptId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmpname() {
            return empname;
        }

        public void setEmpname(String empname) {
            this.empname = empname;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public java.sql.Date getBirthday() {
            return birthday;
        }

        public void setBirthday(java.sql.Date birthday) {
            this.birthday = birthday;
        }

        public Integer getDeptId() {
            return deptId;
        }

        public void setDeptId(Integer deptId) {
            this.deptId = deptId;
        }

        public Emp(String empname, double salary, int age) {
            this.empname = empname;
            this.age = age;
            this.salary = salary;
        }
    }
}
