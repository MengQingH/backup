package 常用类.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URI：统一资源“标识”符，用来唯一的标识互联网上的一个资源
 * URL:统一资源“定位”器，是指向互联网资源的指针，是一种具体的URI，由四部分组成：协议、存放资源的主机域名、资源文件名和端口号
 * 示例：http://www.baidu.com:80/index.……   http：协议，为默认http时隐藏   www.baidu.com:存放资源的主机域名   :80 :端口号，为默认：80时隐藏    index.……：资源文件名，/之后的部分
 */
public class URL类 {
    public static void main(String[] args) throws IOException {
        //绝对路径创建URL对象
        URL u = new URL("http://www.socs.uts.edu.au/MosaicDocs-old/url-primer.html");
        System.out.println(u.getFile());//返回文件名
        System.out.println(u.getHost());//返回主机名
        System.out.println(u.getPort());//返回端口，存在返回80，不存在返回-1
        System.out.println(u.getProtocol());//返回协议
        System.out.println(u.getPath());//返回文件路径
        System.out.println(u.getQuery());//返回参数
        System.out.println(u.toString());

        /**
         * 获取资源：源代码
         * openStream()返回一个InputStream对象
         */
        URL url = new URL("http://www.baidu.com");//默认资源：主页
        InputStream is = url.openStream();
        byte[] b = new byte[1024];
        int m;
        while(-1 != (m = is.read(b))){
            System.out.println(new String(b,0,m));
        }
        is.close();
    }
}
