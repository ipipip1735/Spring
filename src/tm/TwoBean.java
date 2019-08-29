package tm;

import dao.PersonDAO;
import listen.OneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/8/26 9:24.
 */
public class TwoBean {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public TwoBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @Transactional(transactionManager = "txManager")
    public void insert() {

        //方式一：
//        personDAO.insert();//使用DAO对象插入数据
//        personDAO.insert();//使用DAO对象插入数据
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//直接回滚

        //方式二：
        try {
            personDAO.insert();//使用DAO对象插入数据
            personDAO.insert();//使用DAO对象插入数据
            throw new Exception(); //抛出异常
        } catch (Exception e) {
            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//回滚
        }
    }


    @Transactional(transactionManager = "txManager", rollbackFor = Exception.class)
    public void see() {
        System.out.println("~~" + getClass().getSimpleName() + ".see~~");

        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        System.out.println(status.isRollbackOnly());
        System.out.println(status.isCompleted());
    }


    @Transactional(transactionManager = "txManager")
    public void look() {
        applicationEventPublisher.publishEvent(new OneEvent(this, new Object()));
    }



}
