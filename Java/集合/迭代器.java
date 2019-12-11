package 集合;

import java.util.*;

public class 迭代器 {
    public static void main(String[] args) {
        /**
         * 迭代器：用于遍历整个集合或列表
         * 生成：调用集合列表的.iterator()方法返回一个Iterator对象
         * 方法：.next():返回光标处的元素把光标向下移
         *       .hasNext():判断是否有下一个
         *       .remove():移除光标处的元素，光标向后移动
         */
        Set<String> s = new HashSet<>();
        s.add("set");
        Iterator i = s.iterator();
        i.next();
        i.hasNext();
        i.remove();

        /**
         * ListIterator:链表迭代器，用于遍历列表，相比迭代器方法更多
         * 方法：.add():在光标位置处添加元素
         *       .hasNext():下一个是否为空
         *       .hasPrevious():上一个是否为空
         *       .next/previous():返回下一个/前一个，光标移动
         *       .nextIndex/previousIndex():返回下一个/上一个的元素的索引
         *       .remove():移除元素(不返回)
         *       .set():
         */
        List<String> l = new ArrayList();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        ListIterator li = l.listIterator();
        System.out.println(li.nextIndex());
        System.out.println(li.next());//指向第一个元素
        System.out.println(li.nextIndex());//返回下一个元素的索引
        li.remove();
        for (String f:
             l) {
            System.out.println(f);
        }
    }
}
