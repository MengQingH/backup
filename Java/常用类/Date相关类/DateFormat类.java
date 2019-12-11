package 常用类.Date相关类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ava.text.DateFormat--java.text.SimpleDateFormat:时间和字符串的转化
 * DateFormat:抽象类，子类为SimpleDateFormat，
 * SimpleDateFormat初始化时的格式化字符串：代表日期的字母输出相应的时间，其他无意义字符原样输出
 */
public class DateFormat类 {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("y年M月d日，属于第w周");//格式化字符串，根据输入的字符串格式输出时间

        //把时间按照格式化字符串转为字符串
        Date d = new Date(4456654535L);
        String s = df.format(d);
        System.out.println(s);

        //把字符串转为时间
        String s1 = "1998-1-29";
        DateFormat df1 = new SimpleDateFormat("y-M-d");
        Date d1 = df1.parse(s1);
        System.out.println(d1);
    }
}
