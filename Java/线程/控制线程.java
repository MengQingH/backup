package 线程;

/**
 * 线程阻塞：
 *      1、join：合并线程，当前线程A,线程B调用join方法，当前线程A转入阻塞状态，直到线程B运行结束，A才可运行
 *      2、yield：使CPU重新选择执行哪个线程，静态方法
 */
public class 控制线程 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 线程阻塞join、yield
         */
        ZuSe z = new ZuSe();
        Thread t = new Thread(z);
        t.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("main线程"+i);
            if(i == 10)t.join();
        }

        /**
         * 线程休眠，静态方法
         */
        C c = new C();
        Thread thread = new Thread(c);
        thread.start();

        /**
         * 线程优先级
         */
        System.out.println(thread.getPriority());  //getPriority()获取当前线程的优先级
        thread.setPriority(10);           //setPriority()设置当前线程的优先级，最大为10，最小为1，优先级越高，线程执行的概率越大
        thread.setPriority(Thread.MAX_PRIORITY);//最大优先级
        thread.setPriority(Thread.MIN_PRIORITY);//最小优先级
        System.out.println(thread.getPriority());
    }
}
class ZuSe implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("类线程"+i);
        }
    }
}
class C implements Runnable
{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if(i==2) {
                try {
                    Thread.sleep(2000);  //使线程休眠x毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
