package listen;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by Administrator on 2019/8/18.
 */
public class AEBean {
    public AEBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @EventListener({ContextRefreshedEvent.class})
    public void handleContextRefresh() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleContextRefresh~~");
    }

    @EventListener({ContextStartedEvent.class})
    public void handleContextStart() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleContextStart~~");
    }

}
