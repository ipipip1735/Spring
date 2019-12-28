package config;

import async.AsyncBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by Administrator on 2019/12/13 4:52.
 */

/**
 * 配置执行器
 * 不实现AsyncConfigurer接口
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    //增加执行器，可以是TaskExecutor或Executor
    @Bean
    public TaskExecutor te() {
        TaskExecutor  executor = new SimpleAsyncTaskExecutor();
        return executor;
    }
//    @Bean
//    public Executor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(2);
//        executor.setMaxPoolSize(2);
//        executor.setQueueCapacity(500);
//        executor.setThreadNamePrefix("MyPool");
//        executor.initialize();
//        return executor;
//    }



    @Bean
    public AsyncBean asyncBean(){
        System.out.println("~~" + getClass().getSimpleName() + ".asyncBean~~");
        return new AsyncBean();
    }
}

/**
 * 配置执行器
 * 实现AsyncConfigurer接口
 */
//@Configuration
//@EnableAsync
//public class AsyncConfig implements AsyncConfigurer {
//
//    @Override
//    @Bean
//    public Executor getAsyncExecutor() {
//        System.out.println("~~getAsyncExecutor~~");
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(2);
//        executor.setMaxPoolSize(2);
//        executor.setQueueCapacity(500);
//        executor.setThreadNamePrefix("MyPool");
////        executor.initialize();
//
//        return executor;
//    }
//
//    @Bean
//    public AsyncBean asyncBean() {
//        System.out.println("~~" + getClass().getSimpleName() + ".asyncBean~~");
//        return new AsyncBean();
//    }
//
//}
