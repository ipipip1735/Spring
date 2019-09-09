package bind;

/**
 * Created by Administrator on 2019/9/8.
 */
public class Person {
    String name;
    int age;

    public String getName() {
        System.out.println("~~" + getClass().getSimpleName() + ".getName~~");

        return name;
    }

    public int getAge() {
        System.out.println("~~" + getClass().getSimpleName() + ".getAge~~");

        return age;
    }

    public Person() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        name = "";
        age = -1;
    }
}
