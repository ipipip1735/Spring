package mine;

/**
 * Created by Administrator on 2019/8/15 15:28.
 */
public class OneService {
    public OneService() {
        System.out.println("~~OneService~~");
    }

    public static OneService createInstance() {
        System.out.println("~~createInstance~~");
        return new OneService();
    }
}
