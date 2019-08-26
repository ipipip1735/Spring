package tm;

/**
 * Created by Administrator on 2019/8/26.
 */
public class FooService {
    int i;

    public void setI(int i) {
        System.out.println("~~" + getClass().getSimpleName() + ".setI~~");
        this.i = i;
    }

    public FooService() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
    }
}
