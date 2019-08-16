package mine;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/8/16 10:31.
 */
public class AutowiredBean {

    private AnnotationBean ab;

    public AutowiredBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Autowired
    public void show(AnnotationBean ab) {
        System.out.println("~~" + getClass().getSimpleName() + ".show~~");
        System.out.println(ab);
    }

    @Autowired
    public void setCb(AnnotationBean ab) {
        System.out.println("~~" + getClass().getSimpleName() + ".setCb~~");
        this.ab = ab;

    }


    @Resource(name = "annoB")
    public void res(AnnotationBean ab) {
        System.out.println("~~" + getClass().getSimpleName() + ".res~~");
        System.out.println(ab);

    }
}
