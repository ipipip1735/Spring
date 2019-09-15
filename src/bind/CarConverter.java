package bind;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2019/9/9 17:11.
 */
public class CarConverter implements Converter<String, Car> {

    public CarConverter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public Car convert(String source) {
        System.out.println("~~" + getClass().getSimpleName() + ".convert~~");
        System.out.println("source is " + source);

        Car car = new Car();
        System.out.println(car);
        return car;
    }
}
