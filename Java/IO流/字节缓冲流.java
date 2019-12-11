package IO流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class 字节缓冲流 {
    public static void main(String[] args) {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("D:\\IDEAchengxu\\IOfrom.txt"));
            bo = new BufferedOutputStream(new FileOutputStream("D:\\IDEAchengxu\\IOto.txt"));
            byte[] b = new byte[1024];
            int m;
            while ((m = bi.read(b,0,b.length)) != -1) {//读取函数（byte类型数组，从该位开始读，最大读取长度）
                bo.write(b, 0, m);   //写入函数（数组，从该位开始写，写入长度）
                System.out.println(new String(b));
            }
            bo.flush();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                bi.close();
                bo.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
