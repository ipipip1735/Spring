package bind;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2019/9/8.
 */
public class ABeanValidator implements Validator {

    public ABeanValidator() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
        System.out.println("clazz is " + clazz);


        //返回true表示支持此对象验证，框架将调用validate()方法
        //返回false就表示不支持此对象的验证，框架将抛异常
//        return bind.ABean.class.equals(clazz);
        return bind.ABean.class.isAssignableFrom(clazz);//不需要equal()，只需要检查是否为父类
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
        System.out.println("target is " + target);
        System.out.println("errors is " + errors);

        ValidationUtils.rejectIfEmpty(errors, "name", "name is empty");

        ABean aBean = (ABean) target;



    }
}
