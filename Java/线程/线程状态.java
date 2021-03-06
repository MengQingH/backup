package 线程;

/**
 *新建状态（New）：新创建了一个线程对象。
 *就绪状态（Runnable）：也叫可运行状态。线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
 *运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
 *阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
 *   ①等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。
 *   ②同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
 *   ③其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
 *死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
 *
 *停止线程：1、自然终止：程序正常执行完毕
 *          2、外部干涉：
 *              1)、线程类中定义线程体使用的标识
 *              2)、线程体使用该标识
 *              3)、对外声明改变该标识的方法
 *              4)、外部根据条件使用该方法
 */
public class 线程状态 {
    public static void main(String[] args) {
        Test t = new Test();
        new Thread(t).start();
        for (int i = 0; i < 100; i++) {
            if(i == 50)t.stop();   //外部干涉
            System.out.println(i);
        }
    }
}
class Test implements Runnable{
    //线程类中定义线程体使用的标识
    boolean flag = true;
    @Override
    public void run() {
        //线程体使用该标识
        while (flag){
            System.out.println("RunThread");
        }
    }
    //对外声明改变该标识的方法
    void stop(){
        flag = false;
    }
}
