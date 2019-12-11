package IO流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class 字符缓冲流 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            fileReader = new FileReader("D:\\IDEAchengxu\\IOfrom.txt");
            fileWriter = new FileWriter("D:\\IDEAchengxu\\IOto.txt");
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String strings;
            while (true) {
                //读取一行
                strings = bufferedReader.readLine();
                if (strings == null) break;
                System.out.println(strings);
                //bufferedWriter.newLine();   //换行函数
                bufferedWriter.write(strings);
                bufferedWriter.flush();   //两行一起用才能输出到文件
            
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            try{
                fileReader.close();
                fileWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
    }
}
