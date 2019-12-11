# Runtime类
Runtime类是一个封装了JVM进程的类，每一个java程序运行时都是启动了一个JVM进程，那么每个进程都对应一个Runtime实例。

## Runtime类常用命令
* public static Runtime getRuntime() 获取Runtime类的实例
* public long freeMemory() 返回JVM中的空闲内存
* public long maxMemory() 返回JVM最大可用内存
* public void gc() 运行垃圾回收器释放内存
* public Process exec(String command) 执行本机的命令，返回一个进程


Runtime类Demo
```java
//查看JVM信息
System.out.println("max memory:"+ Runtime.getRuntime().maxMemory());
System.out.println("free memory:"+ Runtime.getRuntime().freeMemory());
System.out.println("total memory:"+ Runtime.getRuntime().totalMemory());

//使用Runtime的exec方法启动记事本并在三秒后关闭
Runtime run = Runtime.getRuntime();
Process p = null;
try {
    //exec方法返回一个进程，表示一个进程的操作类，可以使用destroy()方法销毁这个进程
    p = run.exec("notepad.exe");
} catch (IOException e) {
    e.printStackTrace();
}
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
p.destroy();
```