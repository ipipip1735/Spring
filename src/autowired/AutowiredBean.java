package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/9/24 11:50.
 */
@Component
public class AutowiredBean {

    /**
     *  @Autowired + @Qualifier  等价于 @Resource
     */
//    @Autowired @Qualifier("two")
//    @Resource(name = "two")
    public Autowire one;

//    @Autowired
//    @Qualifier("two")
//    @Resource(name = "two")
//    public void setOne(AutowiredOneBean one) {
//        this.one = one;
//    }

//    public AutowiredBean() {
//        this.one = one;
//    }

//    @Autowired
//    public AutowiredBean(@Qualifier("two") AutowiredOneBean one) {
//        System.out.println(one);
//        this.one = one;
//    }
}
