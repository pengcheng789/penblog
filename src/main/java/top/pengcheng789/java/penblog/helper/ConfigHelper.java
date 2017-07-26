package top.pengcheng789.java.penblog.helper;

import top.pengcheng789.java.penblog.ConfigConstant;
import top.pengcheng789.java.penblog.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */

public final class ConfigHelper {
    private static final Properties CONFIG_PROPS
            = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取 JDBC 驱动
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取 JDBC URL
     */
    public static String getJdbcurl(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取 JDBC 用户名
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取 JDBC 密码
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用 JSP 路径
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,
                ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,
                ConfigConstant.APP_ASSET_PATH, "/asset/");
    }

    /**
     * 获取应用文件上传限制
     */
    public static int getAppUploadLimit() {
        return PropsUtil.getInt(CONFIG_PROPS,
                ConfigConstant.APP_UPLOAD_LIMIT, 10);
    }
}
