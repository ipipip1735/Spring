package listen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by Administrator on 2019/8/17 20:16.
 */

/**
 * 仅接收Started事件
 */
public class OneApplicationListenerBean implements ApplicationListener<ContextStartedEvent>{
    public OneApplicationListenerBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onApplicationEvent~~");
        System.out.println("event is " + event);
    }
}
