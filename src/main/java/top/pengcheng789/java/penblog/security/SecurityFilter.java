package top.pengcheng789.java.penblog.security;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import top.pengcheng789.java.penblog.ConfigConstant;
import top.pengcheng789.java.penblog.helper.ConfigHelper;
import top.pengcheng789.java.penblog.security.realm.JdbcRealm;
import top.pengcheng789.java.penblog.security.realm.UserRealm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 安全过滤器
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class SecurityFilter extends ShiroFilter {

    @Override
    public void init() throws Exception {
        super.init();

        WebSecurityManager webSecurityManager = super.getSecurityManager();

        //设置 Realm ，可同时支持多个 Realm ，并按照先后顺序用都好分割
    }

    private void serRealms (WebSecurityManager webSecurityManager) {
        String securityrealms = ConfigHelper.getRealms();

        if (securityrealms != null) {
            // 根据逗号进行拆分
            String[] securityRealmArray = securityrealms.split(",");

            if (securityRealmArray.length > 0) {
                Set<Realm> realms = new LinkedHashSet<>();

                for (String securityRealm : securityRealmArray) {
                    if (securityRealm.equalsIgnoreCase(ConfigConstant.REALMS_JDBC)) {
                        addJdbcRealm(realms);
                    } else if (securityRealm.equalsIgnoreCase(ConfigConstant
                            .REALMS_USER)) {
                        addUserRealm(realms);
                    }
                }

                RealmSecurityManager realmSecurityManager =
                        (RealmSecurityManager)webSecurityManager;
                realmSecurityManager.setRealms(realms);
            }
        }
    }

    private void addJdbcRealm(Set<Realm> realms) {
        JdbcRealm jdbcRealm = new JdbcRealm();
        realms.add(jdbcRealm);
    }

    private void addUserRealm(Set<Realm> realms) {
        Security security = ConfigHelper.getSecurity();

        UserRealm userRealm = new UserRealm(security);
        realms.add(userRealm);
    }

    private void setCache(WebSecurityManager webSecurityManager) {
        if (ConfigHelper.isCache()) {
            CachingSecurityManager cachingSecurityManager
                    = (CachingSecurityManager)webSecurityManager;

            CacheManager cacheManager = new MemoryConstrainedCacheManager();
            cachingSecurityManager.setCacheManager(cacheManager);
        }
    }
}
