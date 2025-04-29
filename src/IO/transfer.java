package IO;

import java.io.*;

public class transfer {
    public static void main(String[] args) {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("src/IO/test.txt"))){  //虽然给定的是FileInputStream，但是现在支持以Reader的方式进行读取
            System.out.println((char) reader.read());
        }catch (IOException e){
            e.printStackTrace();
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src/IO/test.txt"))) {  //虽然给定的是FileOutputStream，但是现在支持以Writer的方式进行写入
                writer.write("lbwnb");   //以操作Writer的样子写入OutputStream
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }