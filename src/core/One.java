package core;

/**
 * Created by Administrator on 2019/8/15 10:52.
 */
public class One {
    public void setS(String s) {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
        this.s = s;
        System.out.println("s is " + s);
    }

    String s;

    public void setI(int i) {
        this.i = i;
        System.out.println("i is " + i);
    }

    int i;

    public void setF(float f) {
        this.f = f;
        System.out.println("f is " + f);
    }

    float f;


    int[] ints;

    public void setInts(int[] ints) {
        this.ints = ints;
        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j] + ",");
        }
    }

    public One() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
    }
}
