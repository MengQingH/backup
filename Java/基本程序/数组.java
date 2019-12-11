package 基本程序;

import java.util.Arrays;

public class 数组 {
    public static void main(String[] args) {
        //动态初始化
        int[] m = new int[3];  
        m[0] = 1;

        //二维数组的初始化
        int[][] m1 = new int[3][];  
        m1[0] = new int[]{1,2,3};
        m1[1] = new int[]{4,5,6,7};
        
        //静态初始化
        int[] m2 = {1,2,3,4,5};

        
        String s = Arrays.toString(m2);//数组到字符串
        char[] m3 = s.toCharArray();   //字符串到字符数组
        System.out.println(m3);      //字符数组输出时,直接输出数组名

        //数组的复制
        int[] a = {0, 1, 2, 3, 4};
        int[] b;
        int[] c = a;      //建立一个引用指向a数组,没有新建数组,c和a都指向同一个数组
        b = Arrays.copyOf(a,a.length);  //堆中新建一个数组,b指向这个数组
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
