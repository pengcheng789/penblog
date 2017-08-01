package top.pengcheng789.java.penblog.security.realm;

import top.pengcheng789.java.penblog.helper.ConfigHelper;
import top.pengcheng789.java.penblog.helper.DatabaseHelper;
import top.pengcheng789.java.penblog.security.password.Md5CredentialsMatcher;

/**
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class JdbcRealm extends org.apache.shiro.realm.jdbc.JdbcRealm {

    public JdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(ConfigHelper.getJdbcAuthcQuery());
        super.setUserRolesQuery(ConfigHelper.getJdbcRolesQuery());
        super.setPermissionsQuery(ConfigHelper.getJdbcPermissionQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}
