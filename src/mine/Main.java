package mine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import scan.CSBean;
import tm.DefaultFooService;
import tm.FooService;
import tm.OneTM;
import tm.TwoTM;

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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CSBean.class);

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
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        tm.OneService oneService = context.getBean("oneService", tm.OneService.class);
        oneService.see();
    }

    private void tm() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //基于XML
//        FooService fooService = (FooService) context.getBean("fooService");//获取Bean
//        int i = fooService.getI();
//        System.out.println("i is " + i);
//
//        fooService.show();


        //基于注解
//        TwoTM two = (TwoTM) context.getBean("twoTM");//获取Bean
//        two.see();
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
