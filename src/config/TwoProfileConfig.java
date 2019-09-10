package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2019/9/10 17:37.
 */
@Configuration
@Profile("default")
public class TwoProfileConfig {

    @Bean
    public OneBean oneBean() {
        System.out.println("~~" + getClass().getSimpleName() + ".oneBean~~");
        System.out.println(this);
        return new OneBean();
    }
}
