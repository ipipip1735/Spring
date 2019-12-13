package core;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

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
        System.out.println(Thread.currentThread());

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("async end");
        AsyncResult<String> asyncResult = new AsyncResult<String>("OK");
        asyncResult.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("~~onFailure~~");
                System.out.println(Thread.currentThread());
            }

            @Override
            public void onSuccess(String result) {
                System.out.println("~~onSuccess~~");
                System.out.println(Thread.currentThread());

            }
        });
        return new AsyncResult<String>("OK");
    }
}
