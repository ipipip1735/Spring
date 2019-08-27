package tm;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by Administrator on 2019/8/26 9:24.
 */
@Transactional("txManager")
public class TwoBean {
    public TwoBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void see() {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");
        System.out.println(TransactionAspectSupport.currentTransactionStatus().isCompleted());
    }

    public void getSelf() {
        System.out.println("~~" + getClass().getSimpleName() + ".getSelf~~");
    }
}
