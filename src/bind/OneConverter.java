package bind;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2019/9/9 17:11.
 */
public class OneConverter implements Converter<String, Car> {

    public OneConverter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public Car convert(String source) {
        System.out.println("~~" + getClass().getSimpleName() + ".convert~~");
        return new Car();
    }
}
