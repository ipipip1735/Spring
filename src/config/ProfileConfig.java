package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2019/9/10 14:40.
 */
@Configuration
@Profile("dev")
@Import(OneProfileConfig.class)
public class ProfileConfig {

    @Bean
    public TwoBean twoBean() {
        System.out.println("~~" + getClass().getSimpleName() + ".twoBean~~");
        System.out.println(this);
        return new TwoBean();
    }


}
