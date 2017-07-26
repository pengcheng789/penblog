package top.pengcheng789.java.penblog.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
