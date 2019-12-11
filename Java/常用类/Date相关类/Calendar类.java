package 常用类.Date相关类;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * java.util.Calendar--java.util.GregorianCalendar:与日历相关的计算
 * 月份：一月为0，二月为1，以此类推，十二月为11
 * 星期：周日为1，周一为2...
 * Calendar:抽象类，子类为GregorianCalendar
 */
public class Calendar类 {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();

        //设置时间
        c.set(2018,4,14,16,33,1);
        //Calendar类中提供了常量，可以直接使用
        c.set(2018,Calendar.FEBRUARY,Calendar.DATE); 
        //可以为Calendar类中的常量附其他值 
        c.set(Calendar.DATE,6);     
        //使用Date对象设置时间   
        c.setTime(new Date());         

        //把日期转为date类        
        Date d = c.getTime();   

        //日期计算，把对应的日期加一段时间，减去时间把数字变为负数
        c.add(Calendar.DATE,10);   
        System.out.println(c.getTime());
    }
}
