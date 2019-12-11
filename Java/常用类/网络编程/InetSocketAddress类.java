package 常用类.网络编程;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddress类 {
    /**
     * 在InetAddress基础上加端口
     * @param args
     */
    public static void main(String[] args) {
        //通过IP地址和端口号创建对象
        InetSocketAddress is1 = new InetSocketAddress("10.130.165.52",123);
        //通过域名和端口号创建对象
        InetSocketAddress is2 = new InetSocketAddress("LocalHost",124);

        InetAddress i1 = is1.getAddress();//返回InetAddress对象
        System.out.println(is1.getPort());//返回端口
        System.out.println(is1.getHostName());//返回域名
    }
}
