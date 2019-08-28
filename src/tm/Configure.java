package tm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2019/8/26 14:51.
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:jdbc.properties"})
//@EnableTransactionManagement(proxyTargetClass=true, mode= AdviceMode.PROXY, order=2)
public class Configure {

    @Value( "${jdbc.url}" )
    private String jdbcUrl;

    @Value( "${jdbc.username}" )
    private String userName;

    @Value( "${jdbc.password}" )
    private String passWd;

    /**
     * 配置数据源对象
     */
    @Bean
    public DataSource dataSource() {

        //方式一：硬编码
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/mine?serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123123");
//        return dataSource;

        //方式二：读取属性配置文件
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWd);
        return dataSource;

    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager txManager() {
        DataSource dataSource = dataSource();
        System.out.println(dataSource.hashCode());
        return  new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置Bean
     */
    @Bean
    public TwoBean twoBean() {
        return  new TwoBean();
    }



}
