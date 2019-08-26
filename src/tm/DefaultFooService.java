package tm;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Random;

/**
 * Created by Administrator on 2019/8/26 9:13.
 */
public class DefaultFooService implements FooService{
    int i;

    public DefaultFooService() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        this.i = new Random().nextInt(100);
    }

    public void show() {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());
    }

    @Override
    public int getI() {
        System.out.println("~~" + getClass().getSimpleName() + ".getI~~");


        try {
            throw new OneException("One Error");
        } catch (OneException ex) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            TransactionAspectSupport.currentTransactionStatus().hasSavepoint();

        }

        return this.i;
    }
}
