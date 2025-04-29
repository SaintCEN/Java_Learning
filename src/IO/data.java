package IO;

import java.io.*;

public class data {
    public static void main(String[] args){
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/IO/test.txt"))){
            System.out.println(dataInputStream.readBoolean());   //直接将数据读取为任意基本数据类型
        }catch (IOException e) {
            e.printStackTrace();
        }

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/IO/output.txt"))){
            dataOutputStream.writeBoolean(false);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
