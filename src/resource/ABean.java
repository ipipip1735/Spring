package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Created by Administrator on 2019/9/23 13:43.
 */
@Component("aBean")
public class ABean {

    @Autowired
    public ResourceLoader resourceLoader;

    String note = "";

    public String getNote() {

        try {
            Path path = resourceLoader.getResource("classpath:res")
                    .getFile()
                    .toPath();
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return note;
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
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
}
