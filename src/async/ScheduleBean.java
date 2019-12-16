package async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Created by Administrator on 2019/12/15 17:17.
 */
public class ScheduleBean {


    //使用@Scheduled注解
////    @Scheduled(fixedDelay = 5000)
////    @Scheduled(fixedRate = 5000)
//    @Scheduled(initialDelay = 10000, fixedRate = 5000)
//    public void scheduling() {
//        System.out.println("scheduling start");
//        System.out.println(Thread.currentThread());
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("scheduling end");
//    }


    //直接注入计划任务器
//    @Autowired
//    TaskScheduler taskScheduler;
//    public void scheduling() {
//        taskScheduler.schedule(() -> {
//            System.out.println("scheduling start" + System.currentTimeMillis());
//            try {
//                Thread.sleep(3000L);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread());
//            System.out.println("scheduling end" + System.currentTimeMillis());
//        }, new CronTrigger("0/5 * * * * *", TimeZone.getTimeZone(ZoneId.of("+8"))));
//    }


    //通过实现SchedulingConfigurer执行计划任务
    public void scheduling() {
        System.out.println("scheduling start");
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("scheduling end");
    }

}
