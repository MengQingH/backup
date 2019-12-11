package 常用类.网络编程.UDP通信;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class 服务器端 {
    public static void main(String[] args) throws IOException {
        //创建服务器端+指定接口
        DatagramSocket server = new DatagramSocket(1234);
        //准备接收容器
        byte[] b = new byte[1024];
        //封装成包
        DatagramPacket packet = new DatagramPacket(b,b.length);//创建DatagramPacket，用来接收长度为length的数据包
        //接收数据
        server.receive(packet);
        //分析数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        System.out.println(new String(data,0,length));
        //释放
        server.close();
    }
}
