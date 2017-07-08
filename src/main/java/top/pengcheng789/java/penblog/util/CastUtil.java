package top.pengcheng789.java.penblog.util;

/**
 * Created by pen on 17-7-2.
 */
public final class CastUtil {
    public static String castString(Object object){
        return CastUtil.castString(object, "");
    }

    public static String castString(Object object, String defaultValue){
        return object != null ? String.valueOf(object) : defaultValue;
    }

    public static int castInt(Object object){
        return CastUtil.castInt(object, 0);
    }

    public static int castInt(Object object, int defaultValue){
        int intValue = defaultValue;
        if(object != null){
            String strValue = castString(object);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }

        return intValue;
    }

    public static boolean castBoolean(Object object){
        return CastUtil.castBoolean(object, false);
    }

    public static boolean castBoolean(Object object, boolean defaultValue){
        boolean booleanValue = defaultValue;
        if(object != null){
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
