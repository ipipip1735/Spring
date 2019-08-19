package aop;

/**
 * Created by Administrator on 2019/8/18.
 */

public class ABean {
    public ABean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
    }
}