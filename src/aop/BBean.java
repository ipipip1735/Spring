package aop;

/**
 * Created by Administrator on 2019/8/20 9:03.
 */
public class BBean implements OneI {

    public BBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
    }
}
