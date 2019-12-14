package mine;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/12/14 7:47.
 */
public class ListenableFutureTaskTrial {

    public static void main(String[] args) {

        ListenableFutureTaskTrial listenableFutureTaskTrial = new ListenableFutureTaskTrial();


//        listenableFutureTaskTrial.listenableFutureTask();
        listenableFutureTaskTrial.asyncResult();


    }


    private void asyncResult() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);

                    AsyncResult.forValue("OK").addCallback(result -> {
                        System.out.println("~~Callback~~");
                        System.out.println(Thread.currentThread());
                    }, Throwable::printStackTrace);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }




    private void listenableFutureTask() {
        //方式一：手动创建线程
//        ListenableFutureTask<String> listenableFutureTask = new ListenableFutureTask(()->{
//            System.out.println("~~Callable~~");
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread());
//            return "yyy";
//        });
//        new Thread(listenableFutureTask).start();
//
//        listenableFutureTask.addCallback(result -> {
//            System.out.println("~~Callback~~");
//            System.out.println(result);
//            System.out.println(Thread.currentThread());
//        }, Throwable::printStackTrace);


        //方式二：使用线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListenableFutureTask<String> listenableFutureTask = new ListenableFutureTask(() -> {
            System.out.println("xxx");
            System.out.println(Thread.currentThread());
            return "yyy";
        });

        listenableFutureTask.addCallback(result -> {
            System.out.println(result);
            System.out.println(Thread.currentThread());
            executorService.shutdown();
        }, Throwable::printStackTrace);
        executorService.submit(listenableFutureTask);

    }
}
