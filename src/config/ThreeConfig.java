package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2019/9/10 9:38.
 */
@Configuration
public class ThreeConfig {

    OneBean oneBean;
    public ThreeConfig(OneBean oneBean) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

        System.out.println(oneBean);
    }


}
