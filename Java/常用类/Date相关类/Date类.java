package 常用类.Date相关类;

import java.util.Date;

/**
 * java.util.Date:与时间相关的类，对象表示一个特定的瞬间，精确到毫秒
 * java中的时间：从1970.1.1零点开始到某个时刻经过的毫秒数，即其类型是长整形数字
 * 相关子类：
 * java.text.DateFormat--java.text.SimpleDateFormat:时间和字符串的转化
 * java.util.Calendar--java.util.GregorianCalendar:与日历相关的计算
 */
public class Date类 {
    public static void main(String[] args) {
        Date d =new Date();//新建对象时不传入参数表示获取当前时间，默认传入当前时间走过的毫秒数，即下面语句
        long t = System.currentTimeMillis();
        System.out.println(d.getTime()+"      "+t);

        Date d1 = new Date(1000);//新建对象时传入参数表示获取经过该时长毫秒时的时间
        System.out.println(d1);     //直接输出Date对象表示输出时间（输出时默认转成本地时间）
        d1.setTime(103154);         //重新设置时间
        d1.getTime();          //返回该Date对象的long类型数值
        System.out.println(d1.toInstant());//把Date类转为Instant类
    }
}
