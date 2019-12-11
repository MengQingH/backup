package IO流;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class 字节流 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\IDEAchengxu\\IOfrom.txt");
            fileOutputStream = new FileOutputStream("D:\\IDEAchengxu\\IOto.txt");
            byte[] b = new byte[1024];
            int temp;
            while (true) {
                temp = fileInputStream.read(b, 0, b.length);
                //read函数读取到文件末尾时会返回-1
                if (temp == -1) break;
                //输出时，要把字节数组转换为字符串输出
                System.out.println(new String(b));
                fileOutputStream.write(b,0,temp);
            }
            //更简便的循环读取
//            while (-1 != (temp = fileInputStream.read(b))){
//                    fileOutputStream.write(b,0,temp);
//                    System.out.println(new String(b));
//            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try{
                fileInputStream.close();
                fileOutputStream.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
