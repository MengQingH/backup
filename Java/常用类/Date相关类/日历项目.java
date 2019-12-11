package 常用类.Date相关类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class 日历项目 {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("请按以下格式输入你想查询的日期(XXXX.XX.XX):");
        String s = in.nextLine();
        DateFormat df = new SimpleDateFormat("y.M.d");
        Date d = df.parse(s);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        c.set(Calendar.DATE,1);
        int a = c.get(Calendar.DAY_OF_WEEK);//获取当前日期的星期数
        int max = c.getActualMaximum(Calendar.DATE);//获取当前月的天数


        System.out.print("日\t一\t二\t三\t四\t五\t六\n");
        for (int i = 1; i < a; i++) {
            System.out.print('\t');
        }
        for (int i = 1; i < max; i++) {
            System.out.print(i+"\t");
            if(c.get(Calendar.DAY_OF_WEEK)==7) {
                System.out.println();
            }
            c.add(Calendar.DATE,1);
        }
    }
}
