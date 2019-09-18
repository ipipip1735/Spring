package mine;

import bind.Car;
import bind.PersoneValidator;
import bind.Person;
import config.AConfig;
import config.BConfig;
import dao.PersonDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import tm.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

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
        profileAnno();
//        tmAnno();

    }

    private void profileAnno() {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.getEnvironment().setActiveProfiles("dev");//设置环境
//        appContext.getEnvironment().setActiveProfiles("dev", "one");//逻辑与，而不是逻辑或
//        appContext.getEnvironment().setDefaultProfiles("dev");//修改默认环境名为dev
        appContext.register(config.ProfileConfig.class, config.OneProfileConfig.class, config.ThreeConfig.class);
        appContext.refresh();

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

        //方式一：注解导入
//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(config.Configure.class);
//        appContext.getBean("aa");
//        appContext.getBean("car");

        //方式二：编程式导入
//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//        appContext.register(BConfig.class, AConfig.class);//等价于BConfig.class中使用@Import(AConfig.class)
//        appContext.refresh();
//        appContext.getBean("car");

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


//        validate();//验证
//        convert();//转换
        formatter();


    }

    private void formatter() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        Car car = (Car) context.getBean("car");
//        car.setDate(new Date());
//        System.out.println(car.getDate());

//        String text = "201901";
//        String pattern = "yyyyMM";



        /**
         * 使用DateFormatter
         */
        //Date 转 String
        Date date = new Date();
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setStylePattern("SS");
//        dateFormatter.setStylePattern("MM");
//        dateFormatter.setStylePattern("LL");
//        dateFormatter.setStylePattern("FF");
        String d = dateFormatter.print(date, new Locale("zh_CN"));
        System.out.println(d);


        //String 转 Date
//        try {
//            DateFormatter dateFormatter = new DateFormatter();
//            dateFormatter.setStylePattern("SS");
//            Date date = dateFormatter.parse("2019-09-17 16:40", new Locale("zh_CN"));
//
//            System.out.println(date);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        /**
         * 使用DateTimeFormatter
         */
        //日期转换
//        LocalDate localDate = LocalDate.of(2016, 8, 23);
//        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(localDate));
//        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(localDate));
//        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(localDate));
//        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDate));

        //时间和日期转换
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 11, 11, 11, 11, 11, 11, ZoneId.of("+8"));
//        String d = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT)
//                .format(zonedDateTime);
//        System.out.println(d);



    }

    private void convert() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ConversionService conversionService = (ConversionService) context.getBean("conversionService");
        Car car = conversionService.convert("o", Car.class);
        System.out.println(car);


    }

    private void validate() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);

        DataBinder dataBinder = new DataBinder(person, "person");//设置要验证的对象
        dataBinder.setValidator(new PersoneValidator());
        dataBinder.validate();


        BindingResult result = dataBinder.getBindingResult(); //获取结果对象
        if (result.hasErrors()) System.out.println("error!");
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
