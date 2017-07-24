package top.pengcheng789.java.penblog.helper;

import org.junit.Test;

import java.util.Map;

/**
 * CreateDate:2017-07-24
 *
 * @author pen
 */
public class BeanHelperTest {
    @Test
    public void showBeanMap() {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            System.out.println(entry.getKey().getName());
        }
    }
}