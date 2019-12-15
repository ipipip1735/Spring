package config;

import async.ScheduleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by Administrator on 2019/12/15 17:16.
 */

/**
 * 配置计划任务
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Bean
    public TaskScheduler scheduledExecutorService() {
        return new ThreadPoolTaskScheduler();
    }

    @Bean
    ScheduleBean scheduleBean() {
        return new ScheduleBean();
    }
}