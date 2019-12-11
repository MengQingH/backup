package 线程;

/**
 * 1、继承实现多线程：继承Thread方法+重写run方法(线程体)
 * 2、使用线程：创建子类对象+调用对象.start方法
 */
public class Thread继承实现线程 {
    public static void main(String[] args) {
        A a = new A();
        a.start();                   //在同一个时间点只能执行一个线程，由cpu管控
        for (int i = 0; i < 10; i++) {
            System.out.println("main方法线程："+i);
        }
    }
}
class A extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A线程："+i);
        }
    }
}

