package 常用类.String及相关类;

/**
 * 不可变字符序列：String
 * 可变字符序列：StringBuffer(线程安全，效率低)，StringBuilder(线程不安全，效率高，常用)：二者相同
 */
public class StringBuffer类 {
    public static void main(String[] args) {
        /**
         * String
         */
        int a = 12345;
        String s1 = "abcdef";
        String s2 = s1.substring(0,3);     //剪切
        String s3 = s1+a;//拼接,与其他类型连接时，会把其他类型转为字符串
        s3 += "1";
        System.out.println(s1+"."+s2+"."+s3);
        System.out.println(s1.equals(s2));    //相等
        s1.equalsIgnoreCase(s2);//忽略大小写
        byte[] b = s1.getBytes();//字符串到字节数组
        s1 = new String(b);  //字节数组到字符串

        /**
         * StringBuffer
         */
        StringBuilder ss = new StringBuilder();  //字符数组长度为16
        StringBuilder s= new StringBuilder("abc");//字符数组长度为字符串的长度加16
        s.append('s');
        s.append(5).append(true).append(b);//方法链，append方法可以连续调用
        System.out.println(s);
        s.delete(1,3);    //删除1到3的字符，包括1不包括3
        s.reverse();   //反转字符串
        s.charAt(2);     //获得并返回该位置的字符
        s.setCharAt(2,'b');   //把某位置的字符设成某字符
        s.insert(3,'v');     //插入
    }
}
