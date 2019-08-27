package tm;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Administrator on 2019/8/27.
 */
public class ThreeBean {
    private final TransactionTemplate transactionTemplate;

    public ThreeBean(PlatformTransactionManager transactionManager) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        this.transactionTemplate = new TransactionTemplate(transactionManager);

        this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        this.transactionTemplate.setTimeout(30);
    }


    public Object see() {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");

        Object o = transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                System.out.println("~~" + getClass().getSimpleName() + ".doInTransaction~~");

                System.out.println("hasSavepoint is " + status.hasSavepoint());
                System.out.println("isCompleted is " + status.isCompleted());
                System.out.println("isNewTransaction is " + status.isNewTransaction());
                System.out.println("isRollbackOnly is " + status.isRollbackOnly());

                Object o = new Object();
                System.out.println(o);
                return o;
            }
        });
        System.out.println(o);
        return o;
    }

    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                System.out.println("~~" + getClass().getSimpleName() + ".doInTransactionWithoutResult~~");

                status.setRollbackOnly();
            }
        });
    }

}
