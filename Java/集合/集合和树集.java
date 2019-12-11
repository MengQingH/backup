package 集合;

import java.util.*;

public class 集合和树集 {//集合中不能包含重复元素，元素无序
    public static void main(String[] args) {
        /**
         * HashSet
         */
        HashSet<String> hs = new HashSet<String>();
        Set<String> s = hs;
        s.add("a");
        s.add("b");
        s.add("c");
        boolean b = s.contains("a");     //是否包含该元素
        boolean r = s.remove("a");     //移除该元素
        int size = s.size();
        System.out.println(b + "." + r + size);
        Iterator<String> i = s.iterator();   //构造一个迭代器用于遍历整个集合
        i.hasNext();   //判断是否有下一个对象
        i.next();      //返回下一个对象并向下移动一个
        if(i.hasNext()){
            String s1 = i.next();   //随机无序
            System.out.println(s1);
        }


        /**
         * 树集：相当于有序的集合，添加元素时会自动排序
         */
        TreeSet<Integer> i1 = new TreeSet<>();
        i1.add(1);
        i1.add(9);
        i1.add(4);
        i1.add(3);
        System.out.println(i);
        i1.first();
        i1.last();//返回树集中的最小最大元素
        i1.pollFirst();
        i1.pollLast();//删除并返回最大最小元素
    }
}