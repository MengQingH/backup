package 线程;

/**
 *同步：也称为并发，多个线程访问同一份资源，如果这些线程中既有读又有写操作时，就会导致变量值或对象的状态出现混乱，从而导致程序异常
 *解决方法：同步块：synchronized(引用类型、类.class、this){}
 *         同步方法：
 *使用synchronized关键字，一个时刻只允许一个线程对资源进行访问
 */
public class 线程同步和锁定 {
    public static void main(String[] args) {
        Web1230 w = new Web1230();
        Thread t1 = new Thread(w,"黄牛");
        Thread t2 = new Thread(w,"a");
        t1.start();
        t2.start();
    }
}
class Web1230 implements Runnable{
    int i = 50;
    boolean b = true;
    @Override
    public void run() {
        test2();
    }

    //线程安全
    synchronized void test2(){
        while (b){
            if(i<=0){
                b = false;
                return ;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+i--);
        }
    }

    //线程不安全
    /*void test1(){
        while (b){
            if(i<=0){
                b = false;
                return;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+i--);   //currentThread表示获取当前线程
        }
    }*/
}