package mine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scan.CSBean;
import tm.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/8/15 11:57.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("~~Main~~");

        Main main = new Main();

        main.xml();//基于XML的配置
//        main.annotation();//基于Annotation的配置


    }

    private void annotation() {
//        coreAnno();
        tmAnno();

    }

    private void tmAnno() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(tm.Configure.class);

        //获取数据源
//        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
//        try {
//            Connection connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        //获取Bean
        TwoBean twoBean = (TwoBean) applicationContext.getBean("twoBean");
        twoBean.see();


    }

    private void coreAnno() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(core.Configure.class);
        applicationContext.getBean("aa");

    }

    private void xml() {
//        ioc();
//        lifecyle();
//        event();
//        aop();
//        tm();
        template();
    }

    private void template() {
//        transactionTemplate();//事务模板
        jdbcTemplate();//JDBC模板
    }

    private void transactionTemplate() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ThreeBean threeBean = context.getBean("threeBean", ThreeBean.class);
        threeBean.see();
    }

    private void jdbcTemplate() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        OneJDBC oneJDBC = context.getBean("oneJDBC", tm.OneJDBC.class);
//        oneJDBC.query();
//        oneJDBC.delete();
//        oneJDBC.insert();
//        oneJDBC.update();
        oneJDBC.batch();

    }

    private void tm() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //基于XML
        //方式一：事务增加在类上
//        OneBean oneBean = (OneBean) context.getBean("oneBean");
//        oneBean.see();

        //方式二：事务增加在接口上
//        FooService fooService = (FooService) context.getBean("fooService");//获取Bean
//        int i = fooService.getI();
//        System.out.println("i is " + i);
//        fooService.show();




        //基于注解
        TwoBean twoBean = (TwoBean) context.getBean("twoBean");
        twoBean.see();
    }

    private void aop() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        aop.ABean aBean = context.getBean("ab", aop.ABean.class);//获取Bean
        aBean.look();


//        aBean.show();//零参数
//        aBean.show(11);//单参数
//        aBean.show(11, "eleven");//多参数


//        try {
//            aBean.error();//接收异常
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //接收返回值
//        String r = aBean.see(Integer.valueOf(333), Integer.valueOf(444));
//        System.out.println(r);
    }

    private void ioc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        One one = context.getBean("one", One.class);
//        one.show();


//        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
//        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("service.xml");
//        genericApplicationContext.refresh();


//        AwareBean aware = context.getBean("aware", AwareBean.class);


    }

    private void lifecyle() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();
    }

    private void event() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        context.start();
//        context.stop();

//        PublishBean publishBean = context.getBean("pb", PublishBean.class);
//        publishBean.dispatch(new Object());

    }
}
