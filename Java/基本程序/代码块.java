package 基本程序;

/**
 * 代码块：程序中用大括号围起来的一段程序
 * 构造块：类中的代码块
 * 静态块：静态的构造块
 */
public class 代码块 {
    public static void main(String[] args) {
        GZK g = new GZK();

        //代码块：方法中用大括号围起来的一段程序
        {              
            System.out.println("代码块");
        }
    }
}
class GZK{
    public GZK(){
        System.out.println("构造函数");
    }//类运行时，构造块先于构造函数初始化
    
    //构造块
    {                                       
        System.out.println("构造块");
    }
    
    //静态块
    static {                                
        System.out.println("静态块");
    }
}