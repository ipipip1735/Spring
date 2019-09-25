package mine;

import bind.Car;
import bind.Teacher;
import config.*;
import autowired.AutowiredBean;
import dao.PersonDAO;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.*;
import resource.ABean;
import tm.ThreeBean;
import tm.TwoBean;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/8/15 11:57.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("~~Main~~");

        Main main = new Main();

//        main.xml();//基于XML的配置
        main.annotation();//基于Annotation的配置


    }

    private void annotation() {

//        coreAnno();
//        autowiredAnno();
//        profileAnno();
//        tmAnno();
//        formatAnno();
//        validateAnno();
//        propertyEditorAnno();

        resourceAnno();

    }

    private void autowiredAnno() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        AutowiredBean autowiredBean = (AutowiredBean) appContext.getBean(AutowiredBean.class);
        System.out.println(autowiredBean.one);
        autowiredBean.one.show();

    }

    private void resourceAnno() {

        //基本使用
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
//        Resource resource = resourceLoader.getResource("classpath:res");
//
//        if(resource.isFile()) System.out.println("isFile");
//        if(resource.isOpen()) System.out.println("isOpen");
//        if(resource.isReadable()) System.out.println("isReadable");
//
//
//        try {
//            System.out.println("contentLength is " + resource.contentLength());
//            System.out.println("createRelative is " + resource.createRelative("classpath:res"));
//
//
//            System.out.println("getURI is " + resource.getURI());
//            System.out.println("getURL is " + resource.getURL());
//            System.out.println("lastModified is " + resource.lastModified());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Resource resource;

//        //访问路径资源
//        resource = new ClassPathResource("res");
//        System.out.println(resource.isFile());
//
//        //系统资源(相对路径)
//        resource = new FileSystemResource("res");
//        System.out.println(resource.isFile());
//
//        //系统资源（绝对路径）
//        resource = new FileSystemResource("E:\\Program\\IntelliJ\\Spring\\Spring\\res");
//        System.out.println(resource.isFile());
//
//        //URL资源
//        try {
//            resource = new UrlResource("");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


        //加载资源
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ResouceConfig.class);
//        ABean aBean = (ABean) context.getBean("aBean");
        ABean aBean = context.getBean(ABean.class);
//        System.out.println(aBean.getTxt());
//        System.out.println(aBean.getText());
        System.out.println(aBean.getNote());





    }

    private void propertyEditorAnno() {

        Car car = new Car();
        DataBinder dataBinder = new DataBinder(car);

        List<PropertyValue> list = new ArrayList<>();
        list.add(new PropertyValue("date", "20191212"));
        PropertyValues propertyValues = new MutablePropertyValues(list);


        PropertyEditor datePropertyEditor = new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                System.out.println("text is " + text);
                setValue(new Date());
            }
        };

        dataBinder.registerCustomEditor(Date.class, datePropertyEditor);
        dataBinder.bind(propertyValues);

        System.out.println(car.getDate());


    }

    private void validateAnno() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        Validator validator = (Validator) appContext.getBean("validator");//获取验证器


        Teacher teacher = new Teacher();
        teacher.setAge(9);


        DataBinder binder = new DataBinder(teacher);
        binder.setValidator(validator);//设置验证器
        binder.validate();

        if (binder.getBindingResult().hasErrors()) System.out.println("Error!");


    }

    private void formatAnno() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(FormatterConfig.class);
        ConversionService conversionService = (ConversionService) appContext.getBean("conversionService");//获取格式化服务


        //方式一：直接使用转换服务
//        try {
//            Class<?> objectType = Car.class;
//            Method readMethod = objectType.getMethod("getDate");
//            Method writeMethod = objectType.getMethod("setDate", Date.class);
//            String name = "date";
//            Property property = new Property(objectType, readMethod, writeMethod, name);//创建属性对象
//
//            String birthday = "20191213";
//
//            TypeDescriptor target = new TypeDescriptor(property);//创建标识符
//            TypeDescriptor source = TypeDescriptor.forObject(birthday);
//
//            if (conversionService.canConvert(source, target)) {//判断是否能转换
//                Date date = (Date) conversionService.convert(birthday, source, target);//转换
//                System.out.println(date);
//            }
//
//
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        //方式二：使用绑定对象（String 转 Date）
//        List<PropertyValue> list = new ArrayList<>();
//        list.add(new PropertyValue("date", "2019-12-12"));
//        PropertyValues propertyValues = new MutablePropertyValues(list);
//
//        Car car = new Car();
//        DataBinder dataBinder = new DataBinder(car, "car");
//        dataBinder.setConversionService(conversionService);
//        dataBinder.bind(propertyValues);
//        System.out.println(car.getDate());


        //方式三：使用绑定对象（String 转 LocalDate）
        List<PropertyValue> list = new ArrayList<>();
        list.add(new PropertyValue("date", "20191212"));
        list.add(new PropertyValue("localDate", "2019-01-10"));
        PropertyValues propertyValues = new MutablePropertyValues(list);
//
        Car car = new Car();
        DataBinder dataBinder = new DataBinder(car, "car");
        dataBinder.setConversionService(new DefaultFormattingConversionService());
        dataBinder.bind(propertyValues);
        System.out.println(car.getDate());
        System.out.println(car.getLocalDate());


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


        validate();//验证
//        convert();//转换
//        formatter();


    }

    private void formatter() {

        /**
         * 自动转换
         * 从Spring容器中取出服务对象完成转换
         */

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ConversionService conversionService = (ConversionService) context.getBean("conversionService");
        if (conversionService.canConvert(String.class, Date.class)) {//判断是否能转换
            Date date = conversionService.convert("19210203", Date.class);//转换
            System.out.println(date);
        }


        /**
         * 使用DateFormatter手动转换
         */
        //Date 转 String
//        Date date = new Date();
//        DateFormatter dateFormatter = new DateFormatter();
//        dateFormatter.setStylePattern("SS");
////        dateFormatter.setStylePattern("MM");
////        dateFormatter.setStylePattern("LL");
////        dateFormatter.setStylePattern("FF");
//        String d = dateFormatter.print(date, new Locale("zh_CN"));
//        System.out.println(d);


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

        /*使用DataBinder验证*/
        //方式一：使用自定义验证器
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = context.getBean("person", Person.class);
//
//        DataBinder dataBinder = new DataBinder(person, "person");//绑定数据对象
//        dataBinder.setValidator(new PersoneValidator());
////        dataBinder.addValidators();//追加其他验证器
//        dataBinder.validate();
//
//        BindingResult result = dataBinder.getBindingResult(); //获取结果对象
//        if (result.hasErrors()) System.out.println("error!");


        //方式二：使用默认验证器（JSR380标准）
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Validator validator = (Validator) context.getBean("validator");//获取JSR380验证器
//
//
//        Teacher teacher = new Teacher();//实例化
//        teacher.setAge(9);//初始化
//
//        DataBinder dataBinder = new DataBinder(teacher, "teacher");//绑定数据对象
//        dataBinder.setValidator(validator); //设置验证器（JSR380标准）
//        dataBinder.addValidators(new Validator() { //追加自定义验证器
//            @Override
//            public boolean supports(Class<?> clazz) {
//                System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
//                System.out.println("clazz is " + clazz);
//                return true;
//            }
//
//            @Override
//            public void validate(Object target, Errors errors) {
//                System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
//                System.out.println("target is " + target);
//                System.out.println("errors is " + errors);
//            }
//        });
//        dataBinder.validate();
//
//        BindingResult result = dataBinder.getBindingResult(); //获取结果对象
//        if (result.hasErrors()) System.out.println("error!");







        /*直接验证（有时候可以直接注入验证器完成验证）*/
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Validator validator = (Validator) context.getBean("validator");

        Teacher teacher = new Teacher();
        teacher.setAge(9);

        BindingResult bindingResult = new BeanPropertyBindingResult(teacher, "teacher");
        validator.validate(teacher, bindingResult);
        if (bindingResult.hasErrors()) System.out.println("error");


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
