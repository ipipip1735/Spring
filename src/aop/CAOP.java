package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2019/8/18.
 */
//@Aspect
public class CAOP implements Ordered{
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    int order;

    public CAOP() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

//    @Pointcut("execution(public * aop.ABean.*())")
    public void pcOne() {}

//    @Before("pcOne()")
    public void one() {
        System.out.println("~~" + getClass().getSimpleName() + ".one~~");
    }


}
