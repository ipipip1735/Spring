package mine;

import aop.OneI;
import listen.PublishBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import scan.CSBean;

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
//        iocBasic();
//        lifecyle();
//        event();
        aop();
    }

    private void aop() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        aop.ABean aBean = context.getBean("ab", aop.ABean.class);
        aBean.look();
//        OneI oneI = aBean;
//        oneI.show();
//        aBean.show(11);
//        aBean.show(11, "eleven");
//        aBean.see(Integer.valueOf(333), Integer.valueOf(444));
//        System.out.println(aBean.see());
    }

    private void iocBasic() {
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
