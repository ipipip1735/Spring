package tm;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2019/8/26 14:51.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass=true, mode= AdviceMode.PROXY, order=2)
public class Configure {


//    public ThreeTM
}
