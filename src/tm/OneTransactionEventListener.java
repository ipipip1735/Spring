package tm;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by Administrator on 2019/8/27.
 */
@Component
public class OneTransactionEventListener {


    public OneTransactionEventListener() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void before(Object o) {
        System.out.println("~~" + getClass().getSimpleName() + ".before~~");
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void after(Object o) {
        System.out.println("~~" + getClass().getSimpleName() + ".after~~");
    }

}
