package IO;

import java.io.*;

public class object {
    public static void main(String[] args) {
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/IO/output.txt"));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/IO/output.txt"))) {
            People people = new People("lbw");
            outputStream.writeObject(people);
            outputStream.flush();
            people = (People) inputStream.readObject();
            System.out.println(people.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
