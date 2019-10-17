package i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by Administrator on 2019/10/17 22:39.
 */
public class OneBean {

    @Autowired
    MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        System.out.println("~~" + getClass().getSimpleName() + ".setMessageSource~~");

        this.messageSource = messageSource;
    }

    public void show() {
        String m = messageSource.getMessage("msg", new Object[]{"one", "two"}, "ddddddd", Locale.CHINA);
        System.out.println(m);

    }
}
