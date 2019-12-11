package IO流;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File类：只能完成文件的新建，重命名，删除等操作，不能读取文件内容
 * 常用类：getName():获取文件名
 *         getPath();获取文件路径
 *         createNewFile():新建文件
 *         delete():删除文件
 *         mkdir():创建单个目录(不能嵌套创建)
 *         mkdirs():嵌套创建目录
 *         list():返回路径下所有的文件名
 *         listFiles(FilenameFilter filter):返回路径下所有的满足文件过滤器条件的文件
 *         isDirectory():是否为目录
 *         isFile():是否为文件
 * 文件过滤器FilenameFilter用法：
 *      定义类实现FilenameFilter接口；
 *      重写boolean accept(File dir,String name)方法,用于遍历dir目录下的所有文件,name为遍历的文件名
 *
 */
public class File类 {
    public static void main(String[] args) {
        File f = new File("D:\\IDEAchengxu");
        String[] s = f.list(new MyFilter(".txt"));
        for (String fileName:
             s) {
            System.out.println(fileName);
        }
    }
}
class MyFilter implements FilenameFilter{
    private String s;

    public MyFilter(String s) {
        this.s = s;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(s);
    }
}
