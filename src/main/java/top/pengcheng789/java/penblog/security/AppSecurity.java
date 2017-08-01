package top.pengcheng789.java.penblog.security;

import top.pengcheng789.java.penblog.helper.DatabaseHelper;

import java.util.Set;

/**
 * 应用安全控制
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class AppSecurity implements Security {

    @Override
    public String getPassword(String mail) {
        String sql = "SELECT password FROM user WHERE mail = ?";
        return DatabaseHelper.query(sql, mail);
    }

    @Override
    public Set<String> getRoleNameSet(String mail) {
        String sql = "SELECT r.role_name FROM user u, user_role ue, role r" +
                "WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.mail = ?";
        return DatabaseHelper.querySet(sql, mail);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name FROM role r, role_permission rp, permission p" +
                "WHERE r.id = rp.role_id AND p.id = rp.permission_id AND r.role_name";
        return DatabaseHelper.querySet(sql, roleName);
    }
}
