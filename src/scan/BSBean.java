package scan;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/8/17 15:58.
 */

@Component
public class BSBean {
    public BSBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }
}
