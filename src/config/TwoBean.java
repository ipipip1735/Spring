package config;

import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2019/9/10 9:20.
 */
public class TwoBean {
    public TwoBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println(this);
    }

    @Bean
    public OneBean oneBean() {
        return new OneBean();
    }
}
