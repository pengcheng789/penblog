package top.pengcheng789.java.penblog;

/**
 * 提供相关配置项常量
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */

public interface ConfigConstant {
    String CONFIG_FILE = "config.properties";

    String JDBC_DRIVER = "jdbc.driver";
    String JDBC_URL = "jdbc.url";
    String JDBC_USERNAME = "jdbc.username";
    String JDBC_PASSWORD = "jdbc_password";

    String APP_BASE_PACKAGE = "app.base_package";
    String APP_JSP_PATH = "app.jap_path";
    String APP_ASSET_PATH = "app.asset_path";
    String APP_UPLOAD_LIMIT = "app.upload_limit";

    String REALMS = "security.realms";
    String REALMS_JDBC = "jdbc";
    String REALMS_USER = "user";

    String SECURITY = "security.user.class";

    String JDBC_AUTHC_QUERY = "security.jdbc.authc_query";
    String JDBC_ROLES_QUERY = "security.jdbc.roles_query";
    String JDBC_PERMISSION_QUERY = "security.jdbc.permission_query";

    String CACHE = "security.cache";
}
