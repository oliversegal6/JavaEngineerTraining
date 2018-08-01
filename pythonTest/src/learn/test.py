
# -*- coding: utf-8 -*-

import sys;
import keyword
print (keyword.kwlist)

x = 'runoob1';
sys.stdout.write(x + '\n')

if True:
    print ("Answer")
    print ("True")
else:
    print ("Answer")
    print ("False")

dictc = dict([('Runoob', 1), ('Google', 2), ('Taobao', 3)])
dict1 = dict(Runoob=1, Google=2, Taobao=3)

tinydict = {'name': 'runoob','code':1, 'site': 'www.runoob.com'}

print (dictc)
print (dict1)
print (tinydict)          # 输出完整的字典
print (tinydict.keys())   # 输出所有键
print (tinydict.values()) # 输出所有值