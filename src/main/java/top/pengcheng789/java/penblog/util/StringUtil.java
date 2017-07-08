package top.pengcheng789.java.penblog.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by pen on 17-7-2.
 */
public final class StringUtil {
    public static boolean isEmpty(String string){
        if(string != null){
            string = string.trim();
        }

        return StringUtils.isEmpty(string);
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
