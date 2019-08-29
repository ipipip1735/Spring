package listen;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 2019/8/18.
 */
public class OneEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OneEvent(Object source, Object data) {
        super(source);
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        System.out.println("source is " + source);
        System.out.println("data is " + data);
    }
}
