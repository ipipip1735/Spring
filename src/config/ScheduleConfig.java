package config;

import async.ScheduleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/12/15 17:16.
 */

/**
 * 配置计划任务器
 * 使用注解执行计划任务
 */
//@Configuration
//@EnableScheduling
//public class ScheduleConfig {
//
//    @Bean
//    public TaskScheduler scheduledExecutorService() {
//        return new ThreadPoolTaskScheduler();
//    }
//
//    @Bean
//    ScheduleBean scheduleBean() {
//        return new ScheduleBean();
//    }
//}

/**
 * 配置计划任务器
 * 实现SchedulingConfigurer接口
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        //使用注册器增加计划任务
        taskRegistrar.addCronTask(()->{
            System.out.println("~~task~~");
            scheduleBean().scheduling();
        }, "0/5 * * * * *");
    }

    @Bean
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(42);
    }

    @Bean
    ScheduleBean scheduleBean() {
        return new ScheduleBean();
    }
}