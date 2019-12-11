package 设计模式;
/**
 工厂设计模式:
    简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例,返回值向上转型的应用。
 */
public class 简单工厂设计模式 {
    public static void main(String[] args) {
        Doll clothDoll = DollFactory.getInstance("cloth");
        if(clothDoll!=null){
            clothDoll.getInfo();
        }
        Doll barbieDoll = DollFactory.getInstance("barbie");
        if(barbieDoll!=null){
            barbieDoll.getInfo();
        }
    }
}
interface Doll{
    void getInfo();
}
class ClothDoll implements Doll{
    @Override
    public void getInfo() {
        System.out.println("布娃娃");
    }
}
class BarbieDoll implements Doll{
    @Override
    public void getInfo() {
        System.out.println("芭比娃娃");
    }
}
class DollFactory{
    public static Doll getInstance(String name){      //根据接口的向上转型返回不同的类对象
        if("cloth".equals(name)){
            return new ClothDoll();
        }else if("barbie".equals("name")){
            return new BarbieDoll();
        }
        return null;
    }
}