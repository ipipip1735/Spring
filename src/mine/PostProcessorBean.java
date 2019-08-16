package mine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2019/8/16 9:51.
 */
public class PostProcessorBean implements BeanPostProcessor {

    public PostProcessorBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("~~" + getClass().getSimpleName() + ".postProcessBeforeInitialization~~");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("~~" + getClass().getSimpleName() + ".postProcessAfterInitialization~~");
        return null;
    }
}
