package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2019/9/11 4:23.
 */
@Configuration
@Profile("three")
public class ThreeProfileConfig {

    @Bean
    public ThreeBean threeBean() {
        System.out.println("~~" + getClass().getSimpleName() + ".threeBean~~");
        System.out.println(this);
        return new ThreeBean();
    }
}
