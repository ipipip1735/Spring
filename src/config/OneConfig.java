package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tm.ThreeTM;

/**
 * Created by Administrator on 2019/9/10 9:28.
 */

/**
 * 版本一
 * 依赖导入的配置类中定义的Bean
 * OneConfig.class 依赖 TwoBean
 */
//@Configuration
//@Import(TwoConfig.class)
//public class OneConfig {
//
//    TwoBean twoBean;
//
//    public OneConfig(TwoBean twoBean) {
//        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
//        System.out.println(twoBean);
//    }
//
//}


/**
 * 版本二
 * 被导入的配置类依赖本配置类中定义的Bean
 * ThreeConfig.class 依赖 OneBean
 */
//@Configuration
//@Import(ThreeConfig.class)
//public class OneConfig {
//
//    @Bean
//    public OneBean oneBean() {
//        return new OneBean();
//    }
//}