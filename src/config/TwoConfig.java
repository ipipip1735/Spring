package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2019/9/10 9:20.
 */
@Configuration
public class TwoConfig {
    public TwoConfig() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");


    }

    @Bean
    public TwoBean twoBean() {
        System.out.println(this);
        return new TwoBean();
    }
}
