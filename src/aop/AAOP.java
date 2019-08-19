package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2019/8/18.
 */
@Aspect
public class AAOP {
    public AAOP() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Pointcut("execution(public void aop.ABean.show())")
    public void one() {}

//    public void one(String s) {
//        System.out.println("~~" + getClass().getSimpleName() + ".one1~~");
//    }
//
//    public void one(String s, int i) {
//        System.out.println("~~" + getClass().getSimpleName() + ".one2~~");
//    }


    @Before("one()")
    public void two() {
        System.out.println("~~" + getClass().getSimpleName() + ".two~~");
    }
}
