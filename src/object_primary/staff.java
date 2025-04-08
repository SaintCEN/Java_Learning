package object_primary;

public abstract class staff {
    protected String name;
    protected int age;
    staff(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void late(){
        System.out.println("I am late.");
    }
    public abstract void exam();
}
