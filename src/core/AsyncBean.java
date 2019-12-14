package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2019/12/13 4:27.
 */
public class AsyncBean {


    @Async
    public void async() {
        System.out.println("async start");
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("async end");
    }

    @Async
    public ListenableFuture<String> asyncWithResult() {
        System.out.println("async start");

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread());
        System.out.println("async end");

        return new AsyncResult<String>("OK");
    }

    @Async
    public ListenableFutureTask<String> asyncWithTask() {

        ListenableFutureTask<String> task = new ListenableFutureTask(() -> {
            System.out.println("async start");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread());
            System.out.println("async end");
            return "OK";
        });

        task.run();
        return task;
    }
}
