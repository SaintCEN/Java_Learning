package object_primary;

public class demo2 {
    public static void main(String[] args) {
        demo1 person = new demo1(19);
        person.name = "SaintCHEN";
        person.sex = "Male";
        demo1.Hello();
        System.out.println(demo1.introduce(person.name,person.sex));
        person.setName("SaintCEN");
        System.out.println(person.name);
        System.out.println(person.get());
        Student student = new Student(13);
        student.name = "Chino";
        Student.Hello();
        String str = student.toString();
        System.out.println(str);
        boolean Flag = (student instanceof Student);
        study.angry();

        Planet earth = Planet.EARTH;
        System.out.println(earth.getChineseName() + ":" + earth.getMass() + "kg");
        System.out.println(earth.surfaceGravity() + " m/s²");
    }
}
