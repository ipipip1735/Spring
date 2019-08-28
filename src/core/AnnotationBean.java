package core;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2019/8/15 15:57.
 */
public class AnnotationBean {

    public AnnotationBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @PreDestroy
    public void pd() {
        System.out.println("~~" + getClass().getSimpleName() + ".pd~~");
    }

    @PostConstruct
    public void pc() {
        System.out.println("~~" + getClass().getSimpleName() + ".pc~~");
    }

    public void init() {
        System.out.println("~~" + getClass().getSimpleName() + ".init~~");
    }

    public void destroy() {
        System.out.println("~~" + getClass().getSimpleName() + ".destroy~~");
    }
}
