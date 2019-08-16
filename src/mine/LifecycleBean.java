package mine;

import org.springframework.context.Lifecycle;

/**
 * Created by Administrator on 2019/8/16.
 */

public class LifecycleBean implements Lifecycle {
    Thread thread;
    boolean isRunning;

    public LifecycleBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    try {
                        Thread.sleep(1000L);
                        System.out.println("go!");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (isRunning)break;
                }
            }
        });
        isRunning = false;
    }

    @Override
    public void start() {
        System.out.println("~~" + getClass().getSimpleName() + ".start~~");

        thread.start();
        isRunning = true;

    }

    @Override
    public void stop() {
        System.out.println("~~" + getClass().getSimpleName() + ".stop~~");

        isRunning = false;

    }

    @Override
    public boolean isRunning() {
        System.out.println("~~" + getClass().getSimpleName() + ".isRunning~~");

        return isRunning;
    }
}
