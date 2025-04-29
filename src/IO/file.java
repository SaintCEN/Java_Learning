package IO;

import java.io.*;
import java.util.Arrays;

public class file {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("src/IO/text.txt")) {
            System.out.println((char) inputStream.read());
            int tmp;
            while ((tmp = inputStream.read()) != -1){
                System.out.println((char)tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream inputStream = new FileInputStream("src/IO/test.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            System.out.println(inputStream.skip(1));
            System.out.println(inputStream.read(bytes,0,2));
            System.out.println(new String(bytes));
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileOutputStream outputStream = new FileOutputStream("src/IO/output.txt")) {
            outputStream.write('c');
            outputStream.write("lbwnb".getBytes());   //也可以直接写入byte[]
            outputStream.write("lbwnb".getBytes(), 0, 1);
            outputStream.flush();  //建议在最后执行一次刷新操作（强制写入）来保证数据正确写入到硬盘文件中
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileOutputStream outputStream = new FileOutputStream("src/IO/output.txt", true)) {  //true表示开启追加模式
            outputStream.write("lb".getBytes());
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileReader reader = new FileReader("src/IO/test2.txt")){
            reader.skip(1);   //现在跳过的是一个字符
            System.out.println((char) reader.read());
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileReader reader = new FileReader("src/IO/test2.txt")){
            char[] str = new char[10];
            reader.read(str);
            System.out.println(str);   //直接读取到char[]中
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("src/IO/test2.txt",true)){
            writer.getEncoding();
            writer.write('牛');
            writer.append('牛');   //其实功能和write一样
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

        File file = new File("src/IO/text.txt");   //直接创建文件对象，可以是相对路径，也可以是绝对路径
        System.out.println(file.exists());   //此文件是否存在
        System.out.println(file.length());   //获取文件的大小
        System.out.println(file.isDirectory());   //是否为一个文件夹
        System.out.println(file.canRead());   //是否可读
        System.out.println(file.canWrite());   //是否可写
        System.out.println(file.canExecute());   //是否可执行

        File fold = new File("src/IO/");
        System.out.println(Arrays.toString(file.list()));   //快速获取文件夹下的文件名称列表
        for (File f : fold.listFiles()){   //所有子文件的File对象
            System.out.println(f.getAbsolutePath());   //获取文件的绝对路径
        }

    }
}
