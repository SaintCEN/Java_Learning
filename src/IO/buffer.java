package IO;

import java.io.*;

public class buffer {
    public static void main(String[] args){
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/IO/test.txt"))){   //传入FileInputStream
            System.out.println((char) bufferedInputStream.read());   //操作和原来的流是一样的
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/IO/test.txt"))){
            bufferedInputStream.mark(1);   //只保留之后的1个字符
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            bufferedInputStream.reset();   //回到mark时的位置
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src/IO/output.txt"))){
            outputStream.write("lbwnb".getBytes());
            outputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter reader = new BufferedWriter(new FileWriter("src/IO/output.txt"))){
            reader.newLine();   //使用newLine进行换行
            reader.write("汉堡做滴彳亍不彳亍");   //可以直接写入一个字符串
            reader.flush();   //清空缓冲区
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
