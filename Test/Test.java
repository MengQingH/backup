import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test{
    public static void main(String[] args){
        // Date date = new Date(1561890119000);
        // System.out.println(date);
        // DateFormat df = new SimpleDateFormat("y年M月d日");
        // String time = df.format(date);
        // System.out.println(time);

        String s = "123a45";
        s.replace("a", "b");
        System.out.println(s);
    }
}