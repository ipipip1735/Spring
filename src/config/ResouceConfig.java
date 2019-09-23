package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import resouce.ABean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * Created by Administrator on 2019/9/23 16:32.
 */
@Configuration
public class ResouceConfig {
    @Bean
    public String text(@Value("res") Resource resource){

        try {
            File file = resource.getFile();
        return new String(Files.readAllBytes(file.toPath()), UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    ABean aBean(){
        return new ABean();
    }


    @Bean
    ResourceLoader resourceLoader(){
        ResourceLoader resourceLoader =   new DefaultResourceLoader();
        System.out.println(resourceLoader);
        return resourceLoader;
    }
}
