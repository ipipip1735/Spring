package config;

/**
 * Created by Administrator on 2019/9/10 9:20.
 */
public class OneBean {
    public OneBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println(this);
    }
}
