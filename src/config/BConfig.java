package config;

import dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/9/10 5:09.
 */
@Configuration
public class BConfig {

    @Bean(initMethod="init", destroyMethod="close")
//    @Scope("prototype")
    public Car car() {
        System.out.println("~~" + getClass().getSimpleName() + ".car~~");

        Car car = new Car();
        return car;
    }
}
