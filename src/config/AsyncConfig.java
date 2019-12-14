package config;

import core.ABean;
import core.AsyncBean;
import core.BBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2019/12/13 4:52.
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        return null;
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