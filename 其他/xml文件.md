## xml文件简介：
xml文件为可扩展标记语言，可以跨越任何平台，不受编程语言和操作系统的限制。

## 组成
1. xml声明
xml声明一般在xml文件的第一行，其中声明了xml文件的version和encoding
```xml
<?xml version="1.0" encoding="UTF-8"?> 
```
2. 标签
标签在xml声明的下面，由一个根标签和多个子标签组成，标签的相关内容：
1. xml标签对大小写敏感
2. 名称中不能含有< &


## 实体
1. xml文件中使用一些有特殊意义的字符如< &等，xml文件无法解析。如果需要使用这些字符，需要使用字符对应的实体，实体必须以&开头，以;结尾。下面是xml文件预定义的五个实体（只有<& 两个符号是严格禁止使用的，剩下的都是合法的）：
    * &lt; <
    * &gt; >
    * &amp; &
    * &apos; '
    * &quot; "
2. 如果文本中有很多< & 字符，则最好放在CDATA部件中，一个CDATA部件形式为：<![CDATA[文本]]>


## DTD
Document Type Definition，文档类型定义，用来描述文档的结构。一个完整的DTD包含：元素的定义规则，元素之间的关系规则，属性的定义规则。也可以理解为DTD声明了我们可以在xml文档中使用哪些标签，定义那些属性
1. 内部DTD文档：<!DUCTYPE 根元素 [定义内容]>，DTD的定义包含在DTD的标签中。只能验证当前文档
2. 外部DTD文档：如果一个DTD需要验证多个文档，可以使用外部DTD。


## schema
schema文件的扩展名是.xsd，是一种类似于DTD的语法检查器，是DTD的升级版，比DTD具备更好的扩展性
1. DTD是以一个标签的形式在xml文件中声明的，而schema是在根节点的属性中声明了约束
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```
2. schema中可以动态的添加或者删除约束，如果需要在上面的约束中添加其他的约束，只需要把该约束以属性的形式添加到根节点中。
```xml
<!-- 新添加了名为AOP的约束 -->
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```
### xmlns
是XML NameSpace的缩写，因为XML文件的标签名称都是自定义的，自己写的和其他人定义的标签很有可能会重复命名，而功能却不一样，所以需要加上一个namespace来区分这个xml文件和其他的xml文件，类似于Java中的package。