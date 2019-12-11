package 基本程序;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;

// /**
//  * lambda表达式：一段带有输入参数的可执行语句块
//  * (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
//  *      statment1;
//  *      statment2;
//  *      return statementM;
//  *  }
//  *  1、参数类型可以省略
//  *  2、参数只有一个时，可以省略小括号
//  *  3、表达式只有一条语句时，可以省略大括号，return和结尾的分号，即
//  *      param->statement
//  * 
//  *函数式接口：对于只有一个抽象方法的接口，需要这种接口的对象时，就可以提供一个lambda表达式。这种接口称为函数式接口
//  *      可以传入参数，重写该抽象方法中的内容。相当于直接调用该方法，不需要新建对象
//  *
//  *方法引用：用::来分隔方法名和对象名或类名,例System.out::println即
//  *      object::instanceMethod
//  *      Class::staticMethod
//  *      Class::instanceMethod 
//  *
//  */
public class lambda表达式 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        List<String> lowerCaseList = new ArrayList<>();
        lowerCaseList = list.stream().map((String name)->name.toLowerCase()).collect(Collectors.toList());
        for (String item:
             lowerCaseList) {
            System.out.println(item);
        }

        JButton j = new JButton("1");

        //函数式接口，相当于重写该抽象方法，并调用
        j.addActionListener(e->{
            
        });
    }
}
