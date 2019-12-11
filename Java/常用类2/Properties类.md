# properties文件：
    Java中的properties文件是一种配置文件，主要用于表达配置信息，文件类型为*.properties，格式为文本文件，文件内容的格式为"键=值"的格式。
    文件中内容的保存格式：
    key1=value1
    key2=value2

# Properties类
该类继承自HashMap类并实现了Map接口，使用键值对的方式来保存属性集，但不同点为键和值都是字符串
## 常用方法：
* setProperty (String key, String value):设置键值
* getProperty(String key):获取该键的值
* load (Reader reader):从输入流中读取属性列表（键和元素对。通过对指定的文件进行装载来获取该文件中的所有键-值对。以供 getProperty (String key)来搜索。
* store(Writer writer, String comments):与load相反，该方法将键值对写到指定的文件中
* Set<String> stringPropertyNames():返回属性列表的键集

## demo
```java
public static void main(String[] args) throws IOException {
        Store();
        Load();
    }

static void Store() throws IOException {
    Properties p = new Properties();
    p.setProperty("url","1");
    p.setProperty("name","2");

    //创建一个输出流，可以是字符或字节流
    OutputStream os = new FileOutputStream("info.properties");
    //通过该输出流把键值对输出到文件中
    p.store(os,null);
    os.close();
}
static void Load() throws IOException {
    Properties p = new Properties();

    Reader r = new FileReader("info.properties");
    //通过输入流把文件中键值对的内容读取到该对象中
    p.load(r);

    //使用对象中储存的键值对
    Set<String> set = p.stringPropertyNames();
    for (String key:
            set) {
        System.out.println(key+":"+p.getProperty(key));
    }
}
```
