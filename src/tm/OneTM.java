package tm;

/**
 * Created by Administrator on 2019/8/26 9:24.
 */
public class OneTM{
    public OneTM() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void see() {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");
    }

    public void getSelf() {
        System.out.println("~~" + getClass().getSimpleName() + ".getSelf~~");
    }
}
