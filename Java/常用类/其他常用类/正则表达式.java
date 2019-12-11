package 常用类.其他常用类;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式定义：描述了一个规则，通过这个规则可以匹配一类字符串，用于处理复杂的文本操作
 * 正则表达式语法：
 *      1、普通字符：字母、汉字、数字、下划线、标点符号表示匹配相应的字符
 *      2、转义字符：\n换行符、\t制表符、\^&${}[]+*\.代表这些符号本身
 *      3、标准字符集集合：\d代表任意一个数字、\w任意一个字母数字下划线、\s空格、制表符、换行符等空白字符中的一个、
 *          .小数点可以匹配任意一个字符（除了换行符）      大写代表相反
 *      4、自定义字符集合[]：除^ -以外所有字符被包含在中括号中后都失去了特殊含义，变为普通字符；除.以外的标准字符集合被包含在中括号中，自定义集合包含该集合
 *          [svj%&]表示匹配其中任意一个字符
 *          [^saf]表示匹配saf字符以外的任意字符
 *          [a-m]匹配a到m之间的任一个字符
 *          [^g-m0-5]匹配除g到m0到3的任意字符
 *      5、量词：(只有量词前第一个表达式重复)
 *          {n}重复n次
 *          {m,n}至少重复m次，至多n次(贪婪模式：匹配次数越多越好，默认；非贪婪模式：匹配次数越少越好，在量词后加？)
 *          {m,}至少n次
 *          ？匹配表达式0次或1次，相当于{0,1}
 *          +至少出现1次，相当于{1,}
 *          *表达式不出现或出现任意次
 *       6、字符边界：匹配符合某种条件的位置
 *          \b匹配单词的开始或结束(表示前面的字符和后面的字符不全是\w)
 *          ^匹配字符串的开始
 *          $匹配字符串的结束
 *       7、选择符和分组：
 *          |或，表示匹配左边或右边，
 *          ()匹配组：
 *       8、预搜索(零宽断言)：只进行子表达式的匹配，但匹配内容不计入最终结果，
 *          (?=xxx):表达式后面为xxx
 *          (?<=xxx)：表达式前面为xxx
 *          (?!xxx)：表达式后面不为xxx
 *          (?<!xxx)：表达式前面不为xxx
 *
 * 匹配模式：
 *      1、IGNORECASE忽略大小写模式：匹配时忽略大小写，默认不忽略
 *      2、SINGLELINE单行模式：整个文本看作只有一个字符串，只有一个开头一个结尾
 *      3、MULTILINE多行模式：每行都是一个字符串，都有一个开头一个结尾，如果需要匹配最开始和结束位置，则使用\A和\Z
 */
public class 正则表达式 {
    public static void main(String[] args) {
        /**
         * 在Java中使用正则表达式：
         *  Pattern:正则表达式的编译形式：
         *      Pattern p = Pattern.compile(r,int);建立正则表达式，并启用相应模式
         *  Matcher:
         */

        //创建表达式对象
        Pattern p = Pattern.compile("\\w+");//java中正则表达式需要把一个\变为两个\
        //创建Matcher对象，包含需要匹配的目标字符串
        Matcher m = p.matcher("asdf5#&64");

        boolean b = m.matches();//把整个字符串与该模式匹配，并转到子字符串
        boolean b1 = m.find();//扫描输入的序列，查找与该模式匹配的一个子序列;并转到下子字符串，下次查找时，会从子字符串中查找
        System.out.println(m.group());//返回找到的字符串
        boolean b2 = m.find();
        System.out.println(b);

        //分组的处理
        Pattern p1 = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher m1 = p1.matcher("aa13**a12");
        while (m1.find()) {
            System.out.println(m1.group());
            System.out.println(m1.group(1));//正则表达式中有分组时，参数表明输出对应的分组
            System.out.println(m1.group(2));
        }

        //替换操作
        Pattern p2 = Pattern.compile("\\d");
        Matcher m2 = p2.matcher("a1b2c3");
        String s = m2.replaceAll("+");//把正则表达式中对应的部分替换为参数中的内容并返回
        System.out.println(s);

        //分割
        String s1 = "a;b;c;d";
        String[] strings = s1.split(";");//按照split里面的参数进行分割后放入字符串数组中
        System.out.println(Arrays.toString(strings));
        String s2 = "a54d46s64g465gh";
        String[] strings1 = s2.split("\\d+");//传入一个正则表达式字符串参数会按照正则表达式的内容进行分割
        System.out.println(Arrays.toString(strings1));
    }
}
