package aop;

import org.aspectj.lang.annotation.*;

/**
 * Created by Administrator on 2019/8/18.
 */
@Aspect
public class AAOP {
    public AAOP() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    /*********引入接口*********/
//    @DeclareParents(value="aop.ABean", defaultImpl=aop.BBean.class)
//    public OneI oi;//声明接口
//
//    @Pointcut("execution(* aop.ABean.*())")
//    public void pcFour() {}//声明切入点
//
//    @Before("pcFour() && this(oneI)")
//    public void four(OneI oneI) {
//        System.out.println("~~" + getClass().getSimpleName() + ".four~~");
//        oneI.show();//调用接口方法
//    }



    /*********传递参数*********/
    //零参数
    @Pointcut("execution(public * aop.ABean.*())")
    public void pcOne() {}
//
    @Before("pcOne()")
    public void one() {
        System.out.println("~~" + getClass().getSimpleName() + ".one~~");
    }
//    @After("pcOne()")
//    public void two() {
//        System.out.println("~~" + getClass().getSimpleName() + ".two~~");
//    }

    //单参数
////    @Pointcut("execution(public * aop.ABean.*(int)) && args(i)")
////    public void pcTwo(int i) {}
////    @Before("pcTwo(n)")
////    public void one(int n) {
////        System.out.println("~~" + getClass().getSimpleName() + ".onei~~");
////        System.out.println("n is " + n);
////    }
//
    //多参数
//    @Pointcut("execution(public * aop.ABean.*(int, String)) && args(i, s)")
//    public void pcThree(int i, String s) {}
//
//    @Before("pcThree(n, s)")
//    public void one(int n, String s) {
//        System.out.println("~~" + getClass().getSimpleName() + ".onei~~");
//        System.out.println("n is " + n);
//    }



    /*********接收返回值*********/
//    @Pointcut("execution(public * aop.ABean.see(..))")
//    public void pcTwo() {}
//
//    @AfterReturning(pointcut = "pcTwo()", returning = "v")
//    public void three(String v) {
//        System.out.println("~~" + getClass().getSimpleName() + ".three~~");
//        System.out.println("v is " + v);
//    }


    /*********接收异常*********/
//    @Pointcut("execution(public * aop.ABean.error())")
//    public void pcThree() {}
//
//    @AfterThrowing(pointcut = "pcThree()", throwing = "error")
//    public void three(Throwable error) {
//        System.out.println("~~" + getClass().getSimpleName() + ".three~~");
//        System.out.println("error is " + error);
//    }


    /*********引入代理对象*********/
//    @Pointcut("execution(public * aop.ABean.show())")
//    public void pcOne() {}
//
//    @Around("pcOne()")
//    public Object four(ProceedingJoinPoint pjp) {
//        System.out.println("~~" + getClass().getSimpleName() + ".four~~");
//
//        System.out.println("getArgs is " + pjp.getArgs());//获取参数
//        System.out.println("getThis is " + pjp.getThis());//获取this对象，即代理对象
//        System.out.println("getTarget is " + pjp.getTarget());//获取目标对象
//        System.out.println("getSignature is " + pjp.getSignature());//获取签名
//        System.out.println("toString is " + pjp.toString());
//
//
//
//        Object retVal = null;
//        try {
//
//            //方式一
//            retVal = pjp.proceed();//调用连接点,即目标对象的方法
//
//            //方式二：传递参数
////            Integer[] integers = new Integer[2];
////            integers[0] = Integer.valueOf(111);
////            integers[1] = Integer.valueOf(222);
////            pjp.proceed(integers);
//
//            System.out.println("four.reVal is " + retVal);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        retVal = "no";
//        // stop stopwatch
//        return retVal;
//    }


}
