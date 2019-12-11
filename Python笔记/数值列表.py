# -*- coding: utf-8 -*-
"""
Created on Thu Mar 22 20:00:24 2018

@author: 大辉
"""

#数值列表的生成与操作
range(1,5)   #1<= <5的数据
int = list(range(1,10))  #创建数值列表
print(int)
int1 = list(range(1,12,3))#从1不断加3到12构成的数
print(int1)
print(min(int1)+"  "+max(int1)+"  "+sum(int1))#最大值最小值平均值

squares = [value ** 2 for value in range(1,10)]#列表解析 
print(squares)

