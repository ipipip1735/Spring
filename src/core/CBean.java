package core;

/**
 * Created by Administrator on 2019/8/15 15:57.
 */
public class CBean {

    public void init() {
        System.out.println("~~" + getClass().getSimpleName() + ".init~~");
    }

    public CBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }
}
