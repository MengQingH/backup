# ResultSet
## 基本的ResultSet:
只能读取一次，且只能向后读取，不能重复读。
```java
//创建方法
Statement s = c.createStatement();
PreparedStatement ps = c.prepareStatement(sql);
```

## 可滚动的ResultSet:
结果集位置可随意移动：
* next():结果集向后移动
* previous():向前移动
* first():返回第一条记录
* absolute(int n):移动到ResultSet中的第几行
* relative(int n):移动到相对当前位置的第几行

```java
//创建方法
Statement s = c.createStatement(int resultSetType,int resultSetConcurrency);
PreparedStatement ps = c.prepareStatement(sql,int resultSetType,int resultSetConcurrency);
```
参数意义：
* resultSetType：设置ResultSet对象的类型能否滚动
    * ResultSet.TYPE_FORWARD_ONLY：只能向前滚动
    * ResultSet.TYPE_SCROLL_INSENSITIVE：可前后滚动，对修改不敏感
    * Result.TYPE_SCROLL_SENSITIVE：可前后滚动，对修改敏感
* resultSetConcurency：设置ResultSet对象能够修改的
    * ResultSet.CONCUR_READ_ONLY：设置为只读类型的参数
    * ResultSet.CONCUR_UPDATABLE：设置为可修改类型的参数





# ResultSetMetadata
该类可以用来获取ResultSet中列的信息。
## 常用方法
* int getColumnCount():获取列数
* String getColumnName(int column):获取指定列的列名

