package 常用类.Wrapper类;

public class 字符串基本类型封装类的转换 {
    public static void main(String[] args) {
        String s = "12";
        Integer I;
        int i;

        //字符串到基本数据类型
        i = Integer.parseInt(s);

        //字符串到Wrapper类
        I = Integer.valueOf(s);

        //基本数据类型到字符串
        s = String.valueOf(i);
        s = Integer.toString(i);
        s = ""+i;

        //字符串到字符数组
        char[] c = new char[5];
        c = s.toCharArray();

        //字符串和字节数组的相互转换
        byte[] b = s.getBytes();         //字符串到字节数组
        String ss = new String(b,0,b.length);   //字节数组到字符串
    }
}
