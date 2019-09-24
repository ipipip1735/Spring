package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2019/9/23 13:43.
 */
@Component("aBean")
public class ABean {

    @Resource(name = "drl")
//    @Autowired
//    @Qualifier("drl")
    public ResourceLoader resourceLoader;

//    @Autowired
//    public ABean(@Qualifier("drl") ResourceLoader resourceLoader) {
//        System.out.println(resourceLoader);
//        this.resourceLoader = resourceLoader;
//    }
    //    public ResourceLoader getResourceLoader() {
//        return resourceLoader;
//    }

//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        System.out.println(resourceLoader);
//        this.resourceLoader = resourceLoader;
//    }

    @Autowired
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Value("res")
    String txt;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
