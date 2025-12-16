import java.lang.reflect.Field;

class Student {
    private String name = "Default Name";
}

public class Reflection_api {
    public static void main(String[] args) throws Exception {
        Student student = new Student();

        // Class object lena
        Class<?> cls = student.getClass();

        // "name" field ko access karna
        Field field = cls.getDeclaredField("name");

        // private hone ki wajah se accessible banana
        field.setAccessible(true);

        // Purana value print
        System.out.println("Before: " + field.get(student));

        // Naya value set karna
        field.set(student, "Jayesh");

        // Badla hua value print
        System.out.println("After: " + field.get(student));
    }
}
