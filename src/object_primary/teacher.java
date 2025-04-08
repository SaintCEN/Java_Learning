package object_primary;

public class teacher extends staff implements study{ //接口可以有多个
    public teacher(String name,int age){
        super(name,age);
    }

    @Override
    public void exam(){
        System.out.println("Don't cheat.");
    }

    @Override
    public void hard(){
        System.out.println("A piece of cake.");
    }
}
