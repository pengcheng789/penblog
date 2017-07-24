package top.pengcheng789.java.penblog.helper;

import org.junit.Test;

import java.util.Set;

/**
 * CreateDate:2017-07-24
 *
 * @author pen
 */
public class ClassHelperTest {

    @Test
    public void showBeanClassSet(){
        Set<Class<?>> beanClassSet = ClassHelper.getBeanclassSet();

        for (Class<?> cls : beanClassSet) {
            System.out.println(cls.getName());
        }
    }
}
