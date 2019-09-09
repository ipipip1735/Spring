package config;

import dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/9/10 5:09.
 */
@Configuration
public class BConfig {

    @Bean
    public Car car() {
        System.out.println("~~" + getClass().getSimpleName() + ".car~~");

        Car car = new Car();
        return car;
    }
}
