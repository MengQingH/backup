package 常用类.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 网络爬虫取数据 {
    public static void main(String[] args) {
        String s = getURL("https://movie.douban.com/top250","utf-8");

        Pattern p = Pattern.compile("(?<=<img width=\"100\" alt=).*(?=\")");
        Matcher m = p.matcher(s);

        while (m.find()){
            System.out.println(m.group());
        }
    }
    public static String getURL(String URLstr,String charset){
        StringBuilder s = new StringBuilder();
        try {
            URL url = new URL(URLstr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),charset));
            String temp;
            while ((temp = br.readLine())!=null){
                s.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }
}
