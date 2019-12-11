package 基本程序;

import java.io.UnsupportedEncodingException;

/**
 * 解码：二进制——解码字符集——>字符
 * 编码：字符——编码字符集——>二进制
 * 乱码原因：
 * 1、编码字符集与解码字符集不统一
 * 2、字节数不完整
 */
public class 解码编码 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s= "中国";
        byte[] b = s.getBytes();//编码与解码字符集统一
        System.out.println(new String(b));

        b = s.getBytes("gbk");//编码字符集和解码字符集不同一，所以出现乱码
        System.out.println(new String(b));

        byte[] d2 = "中国".getBytes("gbk");//用gbk字符集把该字符串转换为字符数组存放在字节数组中
        String s1 = new String(d2,"gbk");//用gbk字符集把字节数组转换为字符串
        System.out.println(s1);

        //乱码原因2：字节数不完整
        System.out.println(new String(d2,0,3));
    }
}
