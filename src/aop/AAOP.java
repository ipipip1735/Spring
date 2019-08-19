package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Administrator on 2019/8/18.
 */
@Aspect
public class AAOP {
    public AAOP() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    //    @Pointcut("execution(public void aop.ABean.*())")
    @Pointcut("execution(public String aop.ABean.*(..))")
    public void pcOne() {}


//    @Pointcut("execution(public * aop.ABean.*(int)) && args(i)")
//    public void pcTwo(int i) {}


//    @Pointcut("execution(public * aop.ABean.*(int, String)) && args(i, s)")
//    public void pcThree(int i, String s) {}


    public void one(String s) {
        System.out.println("~~" + getClass().getSimpleName() + ".one1~~");
    }


    public void one(String s, int n) {
        System.out.println("~~" + getClass().getSimpleName() + ".one2~~");
    }


//    @Before("pcOne()")
//    public void one() {
//        System.out.println("~~" + getClass().getSimpleName() + ".one~~");
//    }

//    @Before("pcThree(n, k)")
//    public void one(int n, String k) {
//        System.out.println("~~" + getClass().getSimpleName() + ".onei~~");
//        System.out.println("n is " + n);
//        System.out.println("k is " + k);
//    }


//    @After("pcOne()")
//    public void two() {
//        System.out.println("~~" + getClass().getSimpleName() + ".two~~");
//    }

//    @AfterReturning(pointcut = "pcOne()", returning = "v")
//    public void three(String v) {
//        System.out.println("~~" + getClass().getSimpleName() + ".three~~");
//        System.out.println("v is " + v);
//    }

//    @AfterThrowing(pointcut = "pcOne()", throwing = "error")
//    public void three(Throwable error) {
//        System.out.println("~~" + getClass().getSimpleName() + ".three~~");
//        System.out.println("error is " + error);
//    }

    @Around("pcOne()")
    public Object four(ProceedingJoinPoint pjp) {
        System.out.println("~~" + getClass().getSimpleName() + ".four~~");

        pjp.getArgs();

        // start stopwatch
        Object retVal = null;
        try {

            //方式一
            retVal = pjp.proceed();

            //方式二：传递参数
//            Integer[] integers = new Integer[2];
//            integers[0] = Integer.valueOf(111);
//            integers[1] = Integer.valueOf(222);
//            pjp.proceed(integers);

            System.out.println("four.reVal is " + retVal);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        retVal = "no";
        // stop stopwatch
        return retVal;
    }

}
