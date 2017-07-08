package top.pengcheng789.java.penblog.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pen on 17-7-2.
 */
public final class PropsUtil {
    public static Properties loadProps(String filename){
        Properties properties = null;
        InputStream inputStream = null;

        try{
            inputStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(filename);
            if (inputStream == null){
                throw new FileNotFoundException(filename + "file is not found.");
            }

            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return properties;
    }

    public static String getString(Properties properties, String key){
        return getString(properties, key, "");
    }

    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if(properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties properties, String key){
        return getInt(properties, key, 0);
    }

    public static int getInt(Properties properties, String key, int defaultValue){
        int value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }

        return value;
    }

    public static boolean isTrue(Properties properties, String key){
        return isTrue(properties, key, false);
    }

    public static boolean isTrue(Properties properties, String key, boolean defaultValue){
        boolean value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }

        return value;
    }
}
