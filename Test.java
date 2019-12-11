import java.util.*;

public class Test{
    public static void main(String[] args){
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