package IO流;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class 字符流 {//字符流只能处理字符纯文本
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("D:\\IDEAchengxu\\IOfrom.txt");
            fw = new FileWriter("D:\\IDEAchengxu\\IOto.txt");
            char[] c = new char[50];
            int i;
            while ((i = fr.read(c,0,c.length)) != -1){
                fw.write(c, 0, i);
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
