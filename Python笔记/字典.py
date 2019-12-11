# -*- coding: utf-8 -*-
"""
Created on Thu Mar 22 20:23:24 2018

@author: 大辉
"""

#字典
mqh = {'sex':'man','age':20,'name':'mengqinghui','a':'a'}
print(mqh['age'])
mqh['weight'] = 130   # 添加键值对
mqh['heigh'] = 180
del mqh['a']       # 删除键值对

for key,value in mqh.items(): # 遍历字典中的所有键值对
    print(key,end="")
    print(value)
    
for name in mqh.keys():    # 遍历所有键
    print(name.title())
    
for name in sorted(mqh.keys()):   # 按顺序遍历所有键
    print(name.title())
    
for value in mqh.values():    # 遍历所有值
    print(str(value).title())
