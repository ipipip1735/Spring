package config;

import autowired.AutowiredBean;
import autowired.AutowiredOneBean;
import autowired.AutowiredTwoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/9/24 11:47.
 */
@Configuration
@ComponentScan("autowired")
public class AutowiredConfig {

    @Bean
    public AutowiredOneBean one() {
        AutowiredOneBean autowiredOneBean = new AutowiredOneBean();
        autowiredOneBean.no = 111;
        return autowiredOneBean;
    }

    @Bean
    public AutowiredTwoBean two() {
        AutowiredTwoBean autowiredTwoBean = new AutowiredTwoBean();
        autowiredTwoBean.no = 222;
        return autowiredTwoBean;
    }

//    @Bean
//    public AutowiredBean abean() {
//        return new AutowiredBean(one());
//    }

}
