package core;

/**
 * Created by Administrator on 2019/8/15 15:38.
 */
public class BBean {
    private int i;

    public BBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");


    }

    public void setI(int i) {
        System.out.println("~~" + getClass().getSimpleName() + ".setC~~");
        this.i = i;
    }
}
