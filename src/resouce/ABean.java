package resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;



/**
 * Created by Administrator on 2019/9/23 13:43.
 */
public class ABean {



    @Autowired
    public ResourceLoader resourceLoader;

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

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


    public ABean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

        System.out.println(resourceLoader);
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
