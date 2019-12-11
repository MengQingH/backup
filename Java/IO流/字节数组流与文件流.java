package IO流;

import java.io.*;

public class 字节数组流与文件流 {
    /**
     * 文件---程序---字节数组(文件输入流、字节数组输出流)
     * 字节数组---程序---文件(字节数组输入流、文件输出流)
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        byte[] by = getByteFromFile("D:\\IDEAchengxu\\IOfrom.txt");

        System.out.println(new String(by));
    }

    //文件---程序---字节数组(文件输入流、字节数组输出流)
    public static byte[] getByteFromFile(String srcPath) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(srcPath));
        byte[] b = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = bi.read(flush)) != -1) { //读取到文件输入流中
            bos.write(flush, 0, len);   //写出到字节数组输出流中
        }
        bos.flush();
        b = bos.toByteArray();       //获取字节数组输出流中的数据
        return b;
    }

    //字节数组---程序---文件(字节数组输入流、文件输出流)
    public static void fromByteToFile(byte[] src){
    }
}
