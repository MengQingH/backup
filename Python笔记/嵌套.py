# -*- coding: utf-8 -*-
"""
Created on Thu Mar 22 21:49:33 2018

@author: 大辉
"""

# 字典列表
stu1 = {'name':'a','age':1}
stu2 = {'name':'b','age':2}
stu3 = {'name':'c','age':3}
stu = [stu1,stu2,stu3]

# 使用代码自动生成相同字典
dogs = []
for dog_number in range(30):
    b = {'voice':'wang','color':'white'}
    dogs.append(b)
for dog in dogs[:3]:
    print(dog)
print(len(dogs))

# 在字典中储存列表
mqh = {'name':'mqh','score':[90,80]}
print(mqh)
