package mine;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2019/8/16.
 */

public class InitBean implements InitializingBean {

    public InitBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @PostConstruct
    public void OneInitAntonation() {
        System.out.println("~~" + getClass().getSimpleName() + ".OneInitAntonation~~");
    }

    @PostConstruct
    public void twoInitAntonation() {
        System.out.println("~~" + getClass().getSimpleName() + ".twoInitAntonation~~");
    }

    public void init() {
        System.out.println("~~" + getClass().getSimpleName() + ".init~~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("~~" + getClass().getSimpleName() + ".afterPropertiesSet~~");
    }
}
