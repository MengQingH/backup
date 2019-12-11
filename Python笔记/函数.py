# -*- coding: utf-8 -*-
"""
Created on Fri Mar 23 19:45:25 2018

@author: 大辉
"""

#定义函数
def greet():
    """显示问候语"""   #函数注释
    print('hello')
greet()

#默认形参
def dog(name,type='dog'):
    print('type'+"'s name is "+name)
    
#等效的函数调用
dog('a')
dog(name='a')

dog('b','fox')
dog(name='b',type='fox')

#返回值
def name(first_name,last_name):
    full_name = first_name+' '+last_name
    return full_name.title()
m = name('meng','hui')
print(m)

