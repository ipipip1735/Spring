package scan;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/8/17.
 */

@Repository
public class CSBean {
    public CSBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }
}
