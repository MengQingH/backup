package 常用类.其他常用类;

import java.util.Arrays;

public class Array类方法 {
    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {1,2,3};
        int[] num3 = {1,5,4};
        boolean b = Arrays.equals(num1,num2);  //相等函数，比较两个数组引用是否指向同一个数组
        b = Arrays.equals(num1,num3);

        num2 = Arrays.copyOf(num1,2);   //复制一个数组，第二个参数为数组的长度
        System.out.println(Arrays.toString(num2));  //把数组转换为字符串
        System.out.println(Arrays.toString(num2).toCharArray());//   字符串转为字符数组

        Arrays.sort(num3);
        System.out.println(Arrays.toString(num3));  //从小到大对数组排序
    }
}
