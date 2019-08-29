package listen;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Administrator on 2019/8/18.
 */
public class OneApplicationEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public OneApplicationEventPublisherAware() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("~~" + getClass().getSimpleName() + ".setApplicationEventPublisher~~");
        System.out.println("applicationEventPublisher is " + applicationEventPublisher);

        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void dispatch(Object o) {
        System.out.println("~~" + getClass().getSimpleName() + ".dispatch~~");
        applicationEventPublisher.publishEvent(new OneEvent(this, o));
    }
}
