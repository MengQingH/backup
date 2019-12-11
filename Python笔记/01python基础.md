## 基础
1. 注释：#
2. 语句以:结尾时，缩进的语句称为代码块

## 数据类型：
1. 字符串：使用'或"包裹的字符
    * 字符串转义字符：/，可使用的转以字符：/t、/n、//
    * r''表示''内部的字符串默认不转义
2. 数值运算
    * /方式的除法的结果是浮点数，//的结果为整数
    * ord()函数获取字符的整数表示，chr()函数把编码转为对应的字符串
    * len()函数可以计算字符串的长度

## 格式化字符串
1. %s表示字符串替换，%d表示整数替换，%f浮点数，有几个占位符，字符串后面的%后就跟几个值，且顺序要对应
```py
"ab/scd%d"%('ab',10);
#ababcd10
```
2. format()方法：字符串调用该方法，在字符串中用{n}表示参数的次序，在方法参数中依次传入要使用的值


## 条件
if后的条件还可以使用变量判断，只要是非空数值，非空字符串，非空list就判断为true
```py
if boolean:
    condition;
elif boolean:
    condition;
else boolean:
    condition;
```

## 循环
1. for···in循环，可以依次把list或tuple中的每个元素迭代出来
```py
for name in names:
    print(name)
```
range()函数可以生成一个整数序列，再通过list函数转换成list
2. while循环
条件满足就不断循环，不满足就退出循环
```py
while boolean:
    condition;
```
循环中还可以使用break和continue

