package bind;

import org.springframework.core.convert.converter.Converter;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Administrator on 2020/9/10 5:15.
 */
public class DateConverter implements Converter<String, Date> {

    public DateConverter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public Date convert(String source) {
        System.out.println("~~" + getClass().getSimpleName() + ".convert~~");
        System.out.println("source is " + source);

        return new Date(Instant.now().toEpochMilli());
    }
}
