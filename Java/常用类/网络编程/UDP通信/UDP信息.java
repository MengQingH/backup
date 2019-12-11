package 常用类.网络编程.UDP通信;

/**
 * UDP:以数据为中心，非面向连接，不安全，效率高
 * 类：DatagramSocket  DatagramPacket
 * 客户端：1、创建客户端（DatagramSocket）+指定接口；    2、准备数据：字节数组     3、打包（DatagramPacket）+服务器地址和端口
 * 4、发送     5、释放资源
 * 服务器端：1、创建服务区端（DatagramSocket）+指定接口；    2、准备接收容器：字节数组，封装成DatagramPacket      3、包接收数据     4、分析    5、释放资源
 */
public class UDP信息 {
    public static void main(String[] args){
    }
}
