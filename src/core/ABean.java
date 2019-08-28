package core;

/**
 * Created by Administrator on 2019/8/15 15:37.
 */
public class ABean {
    private BBean b;
    private CBean c;

    public void setC(CBean c) {
        System.out.println("~~setC~~");
        this.c = c;
    }

    public ABean(BBean b) {
        System.out.println("~~ABean.Constructor~~");

        System.out.println(b);
        this.b = b;
    }
}
