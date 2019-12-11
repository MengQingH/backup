package IO流;

import java.io.*;

/**
 * 输入流：ByteArrayInputStream;字节数组-->流
 * 输出流：ByteArrayInputStream;流-->字节数组
 */
public class 字节数组节点流 {
    public static void main(String[] args) {
        
    }
    public static void read(byte[] src) throws IOException {
        //数据源传入

        //选择流
        InputStream is =new BufferedInputStream(new ByteArrayInputStream(src));
        //操作
        byte[] flush =new byte[1024];
        int len =0;
        while(-1!=(len=is.read(flush))){
            System.out.println(new String(flush,0,len));
        }
        //释放资源
        is.close();
    }
    public static byte[] write() throws IOException{
        //目的地
        byte[] dest;
        //选择流   不同点
        ByteArrayOutputStream bos =new ByteArrayOutputStream();
        //操作 写出
        String msg ="操作与 文件输入流操作一致";
        byte[] info =msg.getBytes();
        bos.write(info, 0, info.length);
        //获取数据
        dest =bos.toByteArray();
        //释放资源
        bos.close();
        return dest;
    }
}
