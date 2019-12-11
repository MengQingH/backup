import java.util.regex.Pattern;

public class Test{
    public static void main(String[] args){
        Pattern p = Pattern.compile("^[a-z0-9A-Z]+([-_.][a-z0-9A-Z]+)?@([a-z0-9A-Z]+[-.])+[a-z0-9A-Z]{2,4}$");
        boolean b = p.matcher("aaa@qq.com").matches();
        System.out.println(b);
    }
}