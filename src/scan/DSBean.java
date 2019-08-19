package scan;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/8/17 15:58.
 */

@Service
public class DSBean {
    public DSBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }
}
