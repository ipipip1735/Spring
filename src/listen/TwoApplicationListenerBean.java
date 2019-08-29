package listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2019/8/17.
 */

/**
 * 接收所有Spring容器上下文事件
 * @see listen.OneApplicationListenerBean
 */
public class TwoApplicationListenerBean implements ApplicationListener {

    public TwoApplicationListenerBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("~~" + getClass().getSimpleName() + ".onApplicationEvent~~");
        System.out.println("event is " + event);
    }
}
