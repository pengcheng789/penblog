package top.pengcheng789.java.penblog.security;

import java.util.Set;

/**
 * Security 接口
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public interface Security {

    /**
     * 根据用户名获取密码
     */
    String getPassword(String username);

    /**
     * 根据用户名获取角色名集合
     */
    Set<String> getRoleNameSet(String username);

    /**
     * 根据角色名获取权限名集合
     */
    Set<String> getPermissionNameSet(String roleName);
}
