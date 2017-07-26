package top.pengcheng789.java.penblog;

import top.pengcheng789.java.penblog.helper.*;
import top.pengcheng789.java.penblog.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
