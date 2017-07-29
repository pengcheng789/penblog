package top.pengcheng789.java.penblog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表单校验注解
 *
 * CreateDate:2017-07-28
 *
 * @author pen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckForm {

    /**
     * 校验表单类别
     */
    String value();
}
