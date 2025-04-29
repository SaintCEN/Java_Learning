package IO;

import java.io.*;
import java.util.Scanner;

public class print {
    public static void main(String[] args) throws FileNotFoundException {
        try(PrintStream stream = new PrintStream(new FileOutputStream("src/IO/test.txt"))){
            stream.println("lbwnb");   //其实System.out就是一个PrintStream
        }catch (IOException e){
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        Scanner scanner1 = new Scanner(new FileInputStream("src/IO/test.txt"));

        System.out.println(scanner);
    }
}

