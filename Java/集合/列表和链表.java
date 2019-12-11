package 集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList使用时可以向上转型为List对象，方便修改，但LinkedList中含有List中没有的方法，最好不要向上转型
 */
public class 列表和链表 {  //列表相当于动态数组
    public static void main(String[] args) {
        /**
         * ArrayList
         * .add():插入元素/在某位置插入元素
         * .addAll():插入Collection中的元素/在某位置插入Collection中的元素
         * .contain():是否包括某元素
         * .containAll():是否包括所有元素
         * .get():获得指定位置的元素
         * .indexOf():返回该值第一次出现的位置，若无，则返回-1
         * .remove():移除并返回某元素/移除某位置的元素
         * .removeAll():移除所有Collection中的元素
         * .set():在某位置插入，并返回原来的元素
         * .toArray():把链表转为数组
         * .size():返回链表中元素的个数
         * .forEach():传入一个lambda表达式，用于遍历整个列表
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add(1,"x");
        arrayList.set(2,"y");
        arrayList.forEach(System.out::print);

        /**
         * LinkedList:相比其他列表链表的插入和删除等操作更方便
         * 新增方法：
         * .addFirst/Last():在列表开头/结尾插入
         * .getFirst/Last():获取列表开头/结尾的元素
         * .offerFirst/Last():在列表开头/结尾插入
         * .peekFirst/Last():获取但不移除列表开头/结尾的元素
         * .pollFirst/Last():获取并移除列表开头/结尾的元素
         * .poll():获取并移除此列表的头
         * .lastIndexOf():
         */
        LinkedList<String> name = new LinkedList<>();
        name.add("meng");
        name.add("qing");
        name.add("hui");
//        name.set(3,"111");//用新元素取代给定的元素，并返回原来的元素
//        name.remove(1);//删除并返回该位置上的元素
//        name.lastIndexOf("meng");//返回最后一次出现的位置

        //列表迭代器
        ListIterator<String> i = name.listIterator();
        i.add("a");//列表迭代器的add方法添加元素的位置由迭代器的位置决定，不一定添加到链表结尾(添加到迭代器位置之前)
        String a = i.next();//next函数返回下一个位置的元素并把迭代器向后移动一个位置
        i.add("b");
        String b = i.next();
        i.remove();       //删除的元素由迭代器位置决定(删除迭代器后面的元素)
        System.out.println(a+"  "+b);
        System.out.println(name);
    }
}
