package config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/9/10 5:08.
 */
//@Component
//@Scope("prototype")
public class Car {
    public Car() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    public void init() {
        System.out.println("~~init~~");
    }

    public void close() {
        System.out.println("~~dsty~~");
    }

}
