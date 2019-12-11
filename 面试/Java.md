## Spring中IoC的理解
* 超级大工厂：对象控制权交给容器，使调用者不必关心对象的创建和管理，专注于逻辑开发。
* 优秀的解耦方式
* 底层实现：反射机制。

## Spring中AOP的理解
关键词：模块化、交叉关注点、横切性质的系统级业务。
* 一种新的模块化方式，专门处理系统各模块中的交叉关注点问题，将具有横切性质的系统级业务提取到切面中，与核心业务逻辑分离。
* 便于系统的扩展。
* 底层实现：动态代理

## 面向对象和面向过程的区别
* 面向过程：
    * 优点：性能比面向对象高，面向对象类调用时需要实例化，开销比较大。
    * 缺点：没有面向对象易维护、易复用、易扩展。
* 面向对象：
    * 优点：易维护、易复用、易扩展。由于面向对象继承、封装、多态的特性，可以设计出低耦合系统。
    * 缺点：性能低。

## Java语言的特点
* 面向对象：继承封装多态
* 平台无关性
* 安全可靠
* 支持多线程

## Java虚拟机
一种可以运行Java字节码的抽象计算机。可以安装在不同的平台上。

## jdk jre
* jre：运行Java程序必须的环境。
* jdk：给开发者提供的开发工具包，包括jre、编译器（javac）、java运行工具、调试工具等。

## 接口和抽象类的区别
* 抽象类中的抽象方法不可以是private，jdk1.8以前，抽象类默认访问权限为protected，jdk1.8时，抽象类默认访问权限变为default；接口中的方法默认访问权限是public，jdk1.8前，抽象类中的方法必须是public，jdk1.8可以是public，也可以是default。
* 抽象类中可以有非抽象的方法，接口中只能有抽象方法。
* 抽象类可以正常定义属性，接口中的属性必须直接初始化，并且访问权限只能是public 或 默认，默认为final类型。
* 接口中的属性或者方法前缀都只能是public或者是默认，不能有protected和private；抽象类中的抽象方法不能是private。
* 一个类可以实现多个接口，但是只能继承一个类。

## 异常
抛出异常:
* throw：一般用于程序中主动抛出某种异常。
* throws：声明方法中可能抛出的异常。

## 对象引用和对象实例
对象实例在堆内存中，对象引用指向对象实例存放在栈内存中。

## String StringBuilder StringBuffer
* String不可变，StringBuilder和StringBuffer可变。
* StringBuffer和String线程安全，StringBuilder线程不安全。
* 三者都是final，不允许继承

StringBuffer通过在方法上添加synchronized关键字来保证线程安全。

## String类不可变原因
String类中的属性字符数组char[] value是private，final的，且没有get和set方法。String类一旦初始化完成上面的变量就无法更改，并且其所提供的接口任何对这些域的修改都返回一个新对象。

## 重载 重写
* 重载：类内多态，静态绑定机制（编译时已经知道要执行哪个方法），方法同名但是参数不同。
* 重写：类间多态，动态绑定机制（运行时确定），子类重写父类中的方法。

## 抽象、封装、继承、多态
* 封装：把对象的属性和行为封装到一个独立的整体，并尽可能隐藏内部细节。
* 继承：一种代码重用机制。
* 多态：分离了做什么和怎么做，从另一个角度将接口和实现分离开来。

## ArrayList LinkedList
1. ArrayList
    * 线程不安全，Arraylist底层使用一个数组来保存元素，还有一个size值为元素的个数，添加时可能会造成数组越界的情况。
    * 默认初始容量为10
    * 扩容：扩大为原数组的1.5倍+1
    * 减少容量：把底层数组的容量调整为当前列表保存的实际元素的大小。
2. LinkedList：LinkedList 不但实现了List接口，还实现了Dequeue接口。因此，LinkedList不但可以当做List来用，还可以当做Stack(push、pop、peek)，Queue(offer、poll、peek)来使用。 
3. 二者比较：
    * ArrayList是基于数组的实现，LinkedList是基于带头节点的双向循环链表的实现。
    * ArrayList支持随机访问，LinkedList不支持。
    * LinkedList可用作栈和队列来使用
    
# Set
Set不包含重复的元素，这也是使用Set最主要的原因。常用到的Set实现有HashSet、TreeSet、LinkedHashSet。一般的，如果需要一个访问快速的Set，你应该使用HashSet；当你需要一个排序的Set，你应该使用TreeSet；当你需要记录下插入时的顺序时，你应该使用LinedHashSet。
<br><img src=img/collection.png><br>
## HashSet
委托给HashMap来实现，实现了Set接口。

## LinkedHashSet
是HashSet的子类，被委托给HashMap的子类LinkedHashMap进行实现，实现了Set接口。LinkedHashSet继承于HashSet，利用下面的HashSet构造函数即可，注意到，其为包访问权限，专门供LinkedHashSet的构造函数调用。LinkedHashSet性能介于HashSet和TreeSet之间，是HashSet的子类，也是一个hash表，但是同时维护了一个双链表来记录插入的顺序，基本方法的复杂度为O(1)。
## TreeSet
委托给TreeMap(TreeMap实现了NavigableSet接口)进行实现，实现了NavigableSet接口(扩展的 SortedSet)。TreeSet是采用树结构实现(红黑树算法)，元素是按顺序进行排列，但是add()、remove()以及contains()等方法都是复杂度为O(log (n))的方法，它还提供了一些方法来处理排序的set，如first()、 last()、 headSet()和 tailSet()等。此外，TreeSet不同于HashSet和LinkedHashSet，其所存储的元素必须是可排序的(元素实现Comparable接口或者传入Comparator)，并且不能存放null值。

# Map
Map的三种常用实现[链表数组HashMap，LinkedHashMap(HashMap的子类，带头结点的双向链表 + HashMap)，基于红黑树的TreeMap(对key排序)]。
## HashMap
哈希表。
<br><img src=img/hashmap.png><br>
* 对null的特别处理：HashMap中可以保存键位Null的键值对，且该键值对是唯一的。如果再次向其中添加键位null的键值对，将覆盖其原值。此外，如果HashMap中存在键位null的键值对，那么一定在第一个桶中。

* 初始容量16，两倍扩容。先添加再检查。public HashMap(int initialCapacity, float loadFactor);为HashMap的构造方法，其中initilCapacity是初始容量，而loadFactor为装载因子，是一个0-1之间的系数，根据这个值来确定需要扩容的阈值，默认为0.75。当map中包含的Entry的数量大于等于threshold = loadFactor * capacity的时候，且新建的Entry刚好落在一个非空的桶上，此刻触发扩容机制，将其容量扩大为2倍。
* 使用时通过位运算获取哈希，效率比取模更高。

## HashMap、HashTable
区别：
* HashMap线程不安全，但是性能更高。HashTable、CurrentHashMap线程安全，HashTable内部的方法都有synchronized修饰，CurrentHashMap中对每一段都使用了lock锁进行保护，比syn关键字的粒度更精细一些，并发性能更好。
* HashMap的键和值允许null的存在，而CurrentHashMap、HashTable不行
* HashMap使用位运算获取哈希，HashTable使用取模获取哈希。
* 初始化时HashMap的初始容量为16，而HashTable的容量为11，前者扩容时乘2，后者乘2+1.

* 因为线程安全，哈希效率的问题，HashMap的效率比HashTable高。

## CurrentHashMap
HashTable使用的是synchronized关键字，其实是给对象加锁，**锁住的是整个对象**，当HashTable的大小增加到一定程度的时候，**性能会急剧下降**，因为迭代时需要被锁住很长时间。而CurrentHashMap对上面的问题进行了优化，使用了分割（Segment），把Map**分为多个HashTable**，再根据哈希来决定具体存放在哪个Segment中，对Segment的操作都加了lock锁，这样就可以对Map的一部分（Segment）上锁，这样影响的是要放入同一个Segment的元素，而其他的Segment的操作不受影响，相对于HashTable提高了多线程环境下的性能。