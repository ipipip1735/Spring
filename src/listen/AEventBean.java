package listen;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by Administrator on 2019/8/18.
 */

/**
 * 基于Annotation的监听器配置
 */
public class AEventBean {
    public AEventBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    /**
     * 接收上下文刷新的通知
     */
    @EventListener({ContextRefreshedEvent.class})
    public void handleContextRefresh() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleContextRefresh~~");
    }


    /**
     * 接收上下文启动的通知
     */
    @EventListener({ContextStartedEvent.class})
    public void handleContextStart() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleContextStart~~");
    }

}
