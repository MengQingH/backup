package IO流;

import java.io.*;

/**
 * 转换流：字节流转为字符流，初始化时可以选择编码方式
 *  若文件编码方式与输入流读取时的方式不同，会出现乱码
 * 1、输入流：InputStreamReader
 * 2、输出流：OutputStreamWriter
 */
public class 转换流 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(  //字符流
                new InputStreamReader(          //转换流
                        new FileInputStream("D:\\IDEAchengxu\\IOfrom.txt"),"UTF-8"));//字节流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
        String s;
        while (null != (s = br.readLine())) {
            System.out.println(s);
        }
        br.close();
    }
}
