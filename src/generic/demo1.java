package generic;

public class demo1<T,M extends Integer> { //泛型类 M必须为Integer或Integer的子类
    /*
    String name;
    String id;
    Object value;  //因为Object是所有类型的父类，因此既可以存放Integer也能存放String

    public demo1(String name, String id, Object value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }
    */
    String name;
    String id;
    T value;   //T会根据使用时提供的类型自动变成对应类型
    M score;

    public demo1(String name, String id, T value,M score) {   //这里T可以是任何类型，但是一旦确定，那么就不能修改了
        this.name = name;
        this.id = id;
        this.value = value;
        this.score = score;
    }

    public static void main(String[] args){
        demo1<String,Integer> example = new demo1<String,Integer>("SaintCHEN","114514","King",123);
        String value = example.value;
        System.out.println(value);
    }
}
