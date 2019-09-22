package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

/**
 * Created by Administrator on 2019/9/18 16:37.
 */
@Configuration
public class FormatterConfig {

    @Bean
    public FormattingConversionService conversionService() {

        //方式一：使用默认格式工具和转换工具
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//        conversionService.addFormatter(new DateFormatter("yyyy-MM-dd"));



        //方式二：仅使用默认格式工具，但禁用默认格式化工具
//        // Use the DefaultFormattingConversionService but do not register defaults
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//        // Ensure @NumberFormat is still supported
//        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
//
//        // Register date conversion with a specific global format
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("yyyyMMdd"));
//        registrar.registerFormatters(conversionService);

        return conversionService;
    }
}
