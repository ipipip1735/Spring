package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * Created by Administrator on 2019/9/20 11:17.
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        System.out.println("~~" + getClass().getSimpleName() + ".validator~~");

        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        return localValidatorFactoryBean;
    }

}
