package aop;

/**
 * Created by Administrator on 2019/8/20 10:46.
 */
public class CBean implements OneI {

    public CBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
    }
}
