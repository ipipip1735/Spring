package listen;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Administrator on 2019/8/18.
 */

public class PublishBean implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public PublishBean() {
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
        applicationEventPublisher.publishEvent(new MineEvent(this, o));
    }
}
