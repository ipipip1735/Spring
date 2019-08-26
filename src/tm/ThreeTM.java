package tm;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by Administrator on 2019/8/26 14:52.
 */
@Transactional
public class ThreeTM {
    public ThreeTM() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void see() {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");
        System.out.println(TransactionAspectSupport.currentTransactionStatus().isCompleted());
    }
}
