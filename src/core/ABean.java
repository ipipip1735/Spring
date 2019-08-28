package core;

/**
 * Created by Administrator on 2019/8/15 15:37.
 */
public class ABean {
    private BBean b;
    private CBean c;

    public void setC(CBean c) {
        System.out.println("~~" + getClass().getSimpleName() + ".setC~~");
        this.c = c;
    }

    public ABean(BBean b) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

        System.out.println(b);
        this.b = b;
    }
}
