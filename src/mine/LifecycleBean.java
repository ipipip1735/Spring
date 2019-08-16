package mine;

import org.springframework.context.Lifecycle;

/**
 * Created by Administrator on 2019/8/16.
 */

public class LifecycleBean implements Lifecycle {
    public LifecycleBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void start() {
        System.out.println("~~" + getClass().getSimpleName() + ".start~~");


    }

    @Override
    public void stop() {
        System.out.println("~~" + getClass().getSimpleName() + ".stop~~");


    }

    @Override
    public boolean isRunning() {
        System.out.println("~~" + getClass().getSimpleName() + ".isRunning~~");

        return false;
    }
}
