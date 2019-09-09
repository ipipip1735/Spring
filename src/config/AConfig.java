package config;

import dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/9/10 4:55.
 */
@Configuration
public class AConfig {

    @Bean
    public Person person() {
        System.out.println("~~" + getClass().getSimpleName() + ".person~~");

        Person person = new Person();
        person.setPerson_name("bob");
        person.setPerson_age(15);
        return person;
    }
}
