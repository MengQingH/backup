package IO流;

import java.io.*;

/**
 * 对象处理流：处理对象：保留数据+类型
 * 序列化：把对象转为二进制 （输出流）ObjectOutputStream(InputStream) writeObject()
 * 反序列化：把二进制转为对象  （输入流）ObjectInputStream(OutputStream) readObject()
 * 注意：先序列化再反序列化，顺序必须一致；只有实现java.io.Serializable接口才可以序列化；不是所有的属性都需要序列化，不需要
 *      序列化的属+transient
 */
public class 对象处理流序列化 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        seri("D:\\IDEAchengxu\\IOto.txt");
        read("D:\\IDEAchengxu\\IOto.txt");
    }
    //反序列化
    public static void read(String Path) throws IOException, ClassNotFoundException {
        ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Path)));
        Object ob = oi.readObject();   //通过readObject反序列化读取对象
        if(ob instanceof Employee){
            Employee e = (Employee) ob;
            System.out.println(e.toString());
        }
        oi.close();
    }

    //序列化
    public static void seri(String destPath) throws IOException {
        Employee e = new Employee("a",1000);
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(destPath)));
        //使用writeObject函数序列化
        os.writeObject(e);
        os.close();
    }
}
class Employee implements java.io.Serializable{//空接口，标识可以序列化
    
    //不需要序列化加transient修饰符
    private transient String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
