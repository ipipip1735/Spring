package mine;

import bind.ABeanValidator;
import dao.PersonDAO;
import listen.OneApplicationEventPublisherAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import tm.*;

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
//        dao();
        bind();
    }

    private void bind() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        bind.ABean aBean = context.getBean("aBean", bind.ABean.class);


        DataBinder dataBinder = new DataBinder(aBean);
        dataBinder.setValidator(new ABeanValidator());
        dataBinder.validate();

        BindingResult result = dataBinder.getBindingResult();
        if (result.hasErrors()) {

        }

    }

    private void template() {
        transactionTemplate();//事务模板
    }

    private void transactionTemplate() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ThreeBean threeBean = context.getBean("threeBean", ThreeBean.class);
        threeBean.see();
    }

    private void dao() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);
//        personDAO.query();
//        personDAO.delete();
//        personDAO.insert();
//        personDAO.update();
//        personDAO.batchInsert();
//        personDAO.batchUpdate();
        personDAO.execute();

    }

    private void tm() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();

        //可探测事务（基于XML）
        //方式一：事务增加在类上
//        OneBean oneBean = (OneBean) context.getBean("oneBean");
//        oneBean.see();

        //方式二：事务增加在接口上
//        FooService fooService = (FooService) context.getBean("fooService");//获取Bean
//        int i = fooService.getI();
//        System.out.println("i is " + i);
//        fooService.show();


        //可探测事务（基于Annotation）
        TwoBean twoBean = (TwoBean) context.getBean("twoBean");
//        twoBean.insert();
        twoBean.look();


        //程序式事务（使用事务模板）
//        template();

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

        //上下文事件
        context.start();//启动上下文，触发started事件
//     context.stop();//停止上下文，触发stopped事件
//        try {
//            Thread.sleep(3000L);
//            context.stop();//停止上下文，触发stopped事件
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        //自定义事件
//        OneApplicationEventPublisherAware publishBean = context.getBean("oneApplicationEventPublisherAware", OneApplicationEventPublisherAware.class);
//        publishBean.dispatch(new Object());//发射自定义事件

    }
}
