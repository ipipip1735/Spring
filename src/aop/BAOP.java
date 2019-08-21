package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * Created by Administrator on 2019/8/18.
 */
@Aspect
@Order(1)
public class BAOP {
    public BAOP() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Pointcut("execution(public * aop.ABean.*())")
    public void pcOne() {}

    @Before("pcOne()")
    public void one() {
        System.out.println("~~" + getClass().getSimpleName() + ".one~~");
    }
}
