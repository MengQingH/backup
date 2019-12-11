package 常用类.其他常用类;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Stream:Stream是元素的集合,可以看成高级版本的Iterator，Iterator只能对元素一个一个进行操作，对Stream，用户只需要给出对元
 *          素进行的操作，Stream就能进行相应的转换
 * 创建Stream:使用静态方法：Stream.of(item,item1……)
 *            数组和集合对象转换
 * 转换Stream:distinct():对Stream里面的元素去重
 *            filter():对元素使用给定的过滤函数进行过滤操作
 *            map():对元素进行转换操作，新生成的流只包括转换生成的元素
 *            flatMap():对元素进行转换操作，并把转换生成的元素加到父集合中
 *            limit(n):对元素进行截断操作，截取前n个元素
 *            skip(n):返回一个丢弃前n个元素之后剩下的元素组成的新Stream
 *            forEach():对流中的每一个对象进行遍历操作
 */
public class Stream流 {
    public static void main(String[] args) {
        Random r = new Random();
        IntStream s = r.ints(20,0,100);
        IntStream is = s.limit(10);
        //Stream只能调用多个方法时只能通过方法链调用，不能先后调用
        is.filter(i->(i<50)).forEach(i-> System.out.print(i+","));
    }
}
