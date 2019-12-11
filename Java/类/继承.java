package 类;

/**
 * 向上转型：父类的引用指向子类，只能调用子类从父类中继承的属性，接口和抽象类之间也发生向上转型
 * 重写(多态)：发生在子类和父类的方法之间，方法名、参数、返回类型完全相同；变量之间不发生多态，静态方法不发生多态
 *      多态常用于参数和返回值之间，见设计模式策略设计模式和简单工厂设计模式
 * 隐藏：子类中的变量名、方法名与父类相同，父类中的元素会隐藏，可通过父类.元素名访问
 */
public class 继承 {
    public static void main(String[] args) {
        Person p = new Person("mh",20);
        Stu s = new Stu("mh",20,1607094147);
        p.info();
        s.info();
        p = s;    //向上转型：父类的变量调用子类的对象，只能调用父类中含有的属性和方法
        p.info();
    }
}
class Person{      //声明为final的类不能生成子类，若其中的某个方法被声明为final，则在子类中不能被重写
    String name;
    int age;

    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }
    public void info(){
        System.out.println(name+" is "+age+" years old");
    }
}
class Stu extends Person{
    int num;

    public Stu(String name,int age,int num){
        super(name,age);             //构造函数必须使用super调用父类的构造器，且必须放在第一行
        this.num = num;             //super关键字可以调用父类的方法或者父类的构造器
    }
    public void info(){          //重写父类中的方法，调用时会优先调用子类中的方法，调用父类中被覆盖的方法可以使用super.方法名
        System.out.println(name+" "+age+" "+num);
    }
}