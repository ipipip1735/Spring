package core;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2019/8/16.
 */

public class CustomScopeBean implements Scope {

    public CustomScopeBean() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");

    }

    @Override
    public String value() {
        System.out.println("~~" + getClass().getSimpleName() + ".value~~");

        return null;
    }

    @Override
    public String scopeName() {
        System.out.println("~~" + getClass().getSimpleName() + ".scopeName~~");
        return null;
    }

    @Override
    public ScopedProxyMode proxyMode() {
        System.out.println("~~" + getClass().getSimpleName() + ".proxyMode~~");
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        System.out.println("~~" + getClass().getSimpleName() + ".annotationType~~");
        return null;
    }
}
