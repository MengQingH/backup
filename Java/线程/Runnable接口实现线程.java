package 线程;

/**
 * 推荐使用接口实现线程
 *      单继承的局限性
 *      方便共享数据
 *
 * 1、Runnable接口实现线程：实现Runnable接口+重写run方法   -->真实角色
 * 2、启动线程(是用静态代理模式)：
 *      创建真实角色
 *      创建代理角色+真实角色引用
 *      代理角色.start
 */
public class Runnable接口实现线程 {
    public static void main(String[] args) {
        //创建真实角色
        B b = new B();
        //创建代理角色+真实角色引用
        Thread thread = new Thread(b);
        //启动线程
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("main线程");
        }

        //方便共享资源
        Web12306 w = new Web12306();
        Thread t1 = new Thread(w,"路人甲");//创建线程并给当前线程起一个名字
        Thread t2 = new Thread(w,"小A");
        Thread t3 = new Thread(w,"黄牛");
        t1.start();
        t2.start();
        t3.start();
    }
}
class B implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("B线程");
        }
    }
}
class Web12306 implements Runnable{
    int i = 50;
    @Override
    public void run() {
        while (true){
            if(i<=0)break;
            System.out.println(Thread.currentThread().getName()+"抢到了"+i--);   //currentThread表示获取当前线程
        }
    }
}

