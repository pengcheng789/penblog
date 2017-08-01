package top.pengcheng789.java.penblog.security.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import top.pengcheng789.java.penblog.ConfigConstant;
import top.pengcheng789.java.penblog.security.Security;
import top.pengcheng789.java.penblog.security.password.Md5CredentialsMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义 Realm
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class UserRealm extends AuthorizingRealm {

    private final Security security;

    public UserRealm(Security security) {
        this.security = security;
        super.setName(ConfigConstant.REALMS_USER);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException {
        if (token == null) {
            throw new AuthenticationException("parameter token is null");
        }

        String username = ((UsernamePasswordToken)token).getUsername();
        String password = security.getPassword(username);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username,
                super.getName()));
        authenticationInfo.setCredentials(password);

        return authenticationInfo;
    }

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("parameter principals is null");
        }

        String username = (String)super.getAvailablePrincipal(principals);
        Set<String> roleNameSet = security.getRoleNameSet(username);
        Set<String> permissionNameSet = new HashSet<>();

        if (roleNameSet != null && roleNameSet.size() > 0) {
            for (String roleName : roleNameSet) {
                Set<String> currentPermissionNameSet = security
                        .getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameSet);
        authorizationInfo.setStringPermissions(permissionNameSet);
        return authorizationInfo;
    }
}
