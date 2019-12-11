package 集合;

import java.util.HashMap;

public class 映射 {
    public static void main(String[] args) {
        HashMap<String,Integer> m = new HashMap<>();//映射用来存放键值对，第一个类为键，第二个类为值
        m.put("a1",1);      //键必须唯一，不能同一个键存放两个值；如果对一个键两次调用put方法，第二个值会取代第一个值
        m.put("a2",2);
        Integer i = m.get("a1");//获取与键对应的值，返回与键对应的对象
        System.out.println(i);
        Boolean b = m.containsKey("a1");//判断映射中是否含有这个键
    }
}
