package top.pengcheng789.java.penblog.service;

import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.util.DatabaseUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by pen on 17-7-6.
 */
public class UserService {
    private static UserService instance;

    private UserService(){
        //TODO Just private the method.
    }

    /**
     * 获取UserService实例
     * @return
     */
    public static UserService getInstance(){
        if (instance == null){
            instance = new UserService();
        }

        return instance;
    }

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUsers(){
        //TODO Get the user list from db.

        String sql = "SELECT * FROM user";
        List<User> users = DatabaseUtil.queryEntityList(User.class, sql);

        return users;
    }

    /**
     * 通过id获取单个用户
     */
    public User getById(String id){
        String sql = "SELECT * FROM user WHERE id='" + id + "'";
        User user = DatabaseUtil.queryEntity(User.class, sql);

        return user;
    }

    /**
     * 通过邮箱获取单个用户
     */
    public User getByMail(String mail){
        String sql = "SELECT * FROM user WHERE mail='" + mail + "'";
        User user = DatabaseUtil.queryEntity(User.class, sql);

        return user;
    }

    /**
     * 添加用户
     * @return
     */
    public boolean createUser(Map<String, Object> fieldMap){
        return DatabaseUtil.insertEntity(User.class, fieldMap);
    }

    /**
     * 更新用户
     */
    public boolean updateUser(String id, Map<String, Object> fieldMap){
        return DatabaseUtil.updateEntity(User.class, id, fieldMap);
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(String id){
        return DatabaseUtil.deleteEntity(User.class, id);
    }

    /**
     * 查询邮箱是否存在
     */
    public boolean isMailExist(String mail){
        boolean result = true;
        if (getByMail(mail) == null){
            result = false;
        }

        return result;
    }
}
