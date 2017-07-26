package top.pengcheng789.java.penblog.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * Created by pen on 17-7-2.
 */
public final class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char)29);

    public static boolean isEmpty(String string){
        if(string != null){
            string = string.trim();
        }

        return StringUtils.isEmpty(string);
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }

    /**
     * 分割字符串
     */
    public static String[] splitString(String string, String separatorChars) {
        return StringUtils.split(string, separatorChars);
    }
}
