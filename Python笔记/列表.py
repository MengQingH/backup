# -*- coding: utf-8 -*-
"""
Created on Thu Mar 22 19:34:46 2018

@author: 大辉
"""
# 列表的创建和使用
str = ['aa', 'bb', 'cc', 'dd']
print(str)
print(str[1]+'  '+str[-1])
str.append('ff')    # 在末尾插入元素
str.insert(4, 'ee')  # 在某位置插入元素
print(str)
del str[0]   # 删除某一个元素
print(str)
s = str.pop(0)  # 删除一个元素并返回该值
str.remove('cc') # 根据内容删除元素  只删一次  多次删除某一元素需要重复使用
str.sort()    # 顺序排序
str.sort(reverse=True)    # 反向排序
str.reverse()    # 反转列表元素
print(str)
a = len(str)   # 列表的长度
print('ff' in str)   # 某元素是否在列表中

str1 = ['a', 'b', 'c', 'd', 'e']
str1[0:2]     # 切片：使用列表的一部分 包含0 1两个元素
print(str1[0:2])
print(str1[:3])  # 不指定起始索引默认从第一个开始  不指定结束索引默认到列表结尾

# 元组：不能修改其中元素的列表 但可以重新赋值