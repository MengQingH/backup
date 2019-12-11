package 常用类.其他常用类;


import java.util.Random;
import java.util.stream.IntStream;

public class 随机数类 {
    public static void main(String[] args) {
        /**
         * 创建一个Random类的对象生成随机数
         *      构造方法：Random():默认参数为System.nanoTime()
         *               Random(seed):
         *      方法：nextInt():返回一个整数，范围为int类型的范围
         *            nextInt(n):返回一个0-n(包括0，不包括n)之间的整数（若需要生成m-n之间的数，在生成的数基础上进行加减运算）
         *            nextDouble()：返回一个0-1.0之间的小数
         *            nextFloat():返回一个0-1.0之间的小数
         *            nextBytes(byteArray):随机生成byte，并存放在定义的数组中，生成的个数等于定义数组的个数
         *      新增方法：创建无穷大的数字流，数字流只能通过某种方式截断(limited)
         *                ints():生成无限个整数，
         *                ints(origin,bound):生成无限个origin-bound之间的整数，返回一个IntStream
         *                ints(size):生成一个大小为size的数据流
         *                ints(size,origin,bound):生成大小为size，数值在o到b之间的数据流
         */
        Random random = new Random();
        Random random1 = new Random(11);
        random1.nextInt(5);
        int a = random.nextInt();     //获得一个随机整数，整数的范围为int的范围
        int b = random.nextInt(2);  //获得一个0到2之间的整数(包括0，不包括2)

        //Stream流
        Random random2 = new Random();
        IntStream is = random2.ints(10);
        is.forEach(System.out::println);//System.out::println可看成e -> System.out.println(e)的缩写形式

        /**
         * 使用Math类的random方法生成随机数：返回带正号的double值，该值大于等于 0.0 且小于 1.0
         */
        double d = Math.random();
        System.out.println(d);
    }
}
