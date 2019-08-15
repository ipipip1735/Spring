package mine;

/**
 * Created by Administrator on 2019/8/15 15:38.
 */
public class BBean {
    private int i;
    public BBean() {
        System.out.println("~~BBean.Constructor~~");

    }

    public void setI(int i) {
        System.out.println("~~setI~~");
        this.i = i;
    }
}
