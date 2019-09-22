package bind;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Random;

/**
 * Created by Administrator on 2019/9/8.
 */
public class PersoneValidator implements Validator {

    public PersoneValidator() {
        Random random = new Random();
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
        System.out.println("clazz is " + clazz);


        //返回true表示支持此对象验证，框架将调用validate()方法
        //返回false就表示不支持此对象的验证，框架将抛异常
//        return bind.ABean.class.equals(clazz);
//        return Person.class.isAssignableFrom(clazz);//不需要equal()，只需要检查是否为父类
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
        System.out.println("target is " + target);
        System.out.println("errors is " + errors);

        //方式一
//        ValidationUtils.rejectIfEmpty(errors, "name", "xxx", "YYY");

        //方式二
//        Person person = (Person) target;
//        if(person.name == null) errors.rejectValue("name", "xxx", "YYYY");

    }
}
