package 常用类.网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress类 {
    /**
     * 主机：internet主机，与Internet相连的计算机都称为主机，有自己的域名和IP地址
     * InetAddress:封装计算机的IP地址和DNS(域名)，没有端口
     * 无构造方法，通过静态方法返回对象:1、getLocalHost()(本机)   2、getByName()参数为IP地址或域名
     * @param args
     */
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost()创建InetAddress对象
        InetAddress inet1 = InetAddress.getLocalHost();//getLocalHost方法创建一个包含本机ip和域名的主机
        System.out.println(inet1.getHostAddress());//返回InetAddress对象中的ip地址
        System.out.println(inet1.getHostName());//返回InetAddress对象中的DNS

        //使用域名得到InetAddress对象
        InetAddress inet2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet2.getHostAddress());

        //使用IP地址获得InetAddress对象
        InetAddress inet3 = InetAddress.getByName("10.130.165.52");
        System.out.println(inet3.getHostName());//如果IP地址不存在或DNS服务器不允许进行IP地址和服务器的映射，getHostName方法就直接输出IP地址
    }
}
