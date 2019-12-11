package 常用类.网络编程.UDP通信;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class 客户端 {
    public static void main(String[] args) throws IOException {
        //创建客户端+指定接口
        DatagramSocket client = new DatagramSocket(1333);
        //准备数据
        String mas = "udp编程";
        byte[] b = mas.getBytes();
        //打包+服务器地址和端口   DatagramPacket(byte[] buf, int length, SocketAddress address)用来将长度为 length 的包发送到指定主机上的指定端口号
        //DatagramPacket(byte[] buf, int length, InetAddress address, int port)构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号
        DatagramPacket packet = new DatagramPacket(b,b.length,new InetSocketAddress("localhost",1234));
        //发送
        client.send(packet);
        //释放
        client.close();
    }
}
