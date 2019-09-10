package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2019/9/10 9:38.
 */
@Configuration
@Profile("default")
public class ThreeConfig {

    public ThreeConfig() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


}
