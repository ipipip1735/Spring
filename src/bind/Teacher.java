package bind;

import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2019/9/20 11:29.
 */
public class Teacher {
    @Min(10)
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
