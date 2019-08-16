package mine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Administrator on 2019/8/15.
 */

public class AwareBean implements ApplicationContextAware {

    public AwareBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

    }

    @Autowired
    public void tk(CBean cc) {
        System.out.println("~~" + getClass().getSimpleName() + ".tk~~");
        System.out.println(cc);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("~~" + getClass().getSimpleName() + ".setApplicationContext~~");
    }
}
