package core;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2019/8/16 11:00.
 */
@Configurable
public class FactoryBean {

    public FactoryBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Bean
    public DBean dBean(){
        return new DBean();
    }
}
