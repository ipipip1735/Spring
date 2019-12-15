package config;

import core.ABean;
import core.BBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2019/8/28 8:55.
 */
@Configuration
@Import(BConfig.class)
public class Configure {

    @Bean
    public ABean aa(){
        System.out.println("~~" + getClass().getSimpleName() + ".aa~~");
        BBean bb = bb();
        System.out.println(bb);
        bb = bb();
        System.out.println(bb);
        return new ABean(bb);
    }

    @Bean
    public BBean bb(){
        System.out.println("~~" + getClass().getSimpleName() + ".bb~~");

        BBean bb = new BBean();
        System.out.println(bb);
        return bb;
    }

}
