package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2019/9/10 14:40.
 */
@Configuration
//@Profile("dev&one")
//@Profile("dev|one")
//@Profile({"dev", "one"})
public class OneProfileConfig {

    @Bean
    @Profile("dev")
    public OneBean oneBean() {
        System.out.println("~~" + getClass().getSimpleName() + ".oneBean~~");
        System.out.println(this);
        return new OneBean();
    }
}
