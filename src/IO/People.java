package IO;

import java.io.Serializable;

public class People implements Serializable {
    String name;

    public People(String name){
        this.name = name;
    }
}
