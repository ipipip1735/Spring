package mine;

import org.springframework.util.AntPathMatcher;

import java.util.Map;

/**
 * Created by Administrator on 2019/12/2 10:24.
 */
public class AntPathMatcherTrial {
    public static void main(String[] args) {
        AntPathMatcherTrial antPathMatcherTrial = new AntPathMatcherTrial();


//        antPathMatcherTrial.combine();

//        antPathMatcherTrial.extractPathWithinPattern();
//        antPathMatcherTrial.extractUriTemplateVariables();
//        antPathMatcherTrial.match();

    }

    private void combine() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String combine = antPathMatcher.combine("11", "22");
        System.out.println(combine);
    }

    private void extractUriTemplateVariables() {

        AntPathMatcher antPathMatcher = new AntPathMatcher();
        Map<String, String> map = antPathMatcher.extractUriTemplateVariables("com/{filename:\\w+}.jsp", "com/test.jsp");
        System.out.println(map);

    }

    private void match() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean b = antPathMatcher.match("com/{filename:\\w+}.jsp", "com/test.jsp");
        System.out.println(b);

    }

    private void extractPathWithinPattern() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        String path = antPathMatcher.extractPathWithinPattern("/docs/cvs/commit.html", "/docs/cvs/commit.html");
//        String path = antPathMatcher.extractPathWithinPattern("/docs/*", "/docs/cvs/commit");
        String path = antPathMatcher.extractPathWithinPattern("/docs/**/*.html", "/docs/cvs/commit.html");
//        String path = antPathMatcher.extractPathWithinPattern("*", "/docs/cvs/commit.html");
        System.out.println(path);
    }
}
