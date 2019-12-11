package IO流;

import java.io.*;

/**
 * 数据类型处理流：处理对象为基本数据类型+字符串：保留数据+类型(写入的数据是为了储存数据，记事本打开有可能是乱码)
 *      (字节流子类)
 * 输入流：DataInputStream(InputStream)   readXXX
 * 输出流：DataOutputStream(OnputStream)    writeXXX
 */
public class 基本数据类型处理流 {
    public static void main(String[] args) throws IOException {
        write("D:\\IDEAchengxu\\IOto.txt");
        read("D:\\IDEAchengxu\\IOto.txt");
    }
    //从文件中读取数据+类型
    public static void read(String srcPath) throws IOException {
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(srcPath)));
        
        //读取顺序和写出一致，必须存在才能读取,不一致数据存在问题
        int i = dis.readInt();
        String s = dis.readUTF();
        double d = dis.readDouble();

        dis.close();
        System.out.println(i+" "+s+" "+d);
    }
    //数据+类型输出到文件中
    public static void write(String srcPath) throws IOException {
        int a = 22;
        String s = "abc";
        double f =  6546.52611;

        DataOutputStream bos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(srcPath)));
        //输出顺序为读取时的顺序
        bos.writeInt(a);
        bos.writeUTF(s);
        bos.writeDouble(f);

        bos.flush();
        bos.close();
    }
}
