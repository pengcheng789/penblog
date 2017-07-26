package top.pengcheng789.java.penblog.service;

import top.pengcheng789.java.penblog.annotation.Service;
import top.pengcheng789.java.penblog.bean.FileParam;
import top.pengcheng789.java.penblog.helper.ServletHelper;
import top.pengcheng789.java.penblog.helper.UploadHelper;
import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.helper.DatabaseHelper;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pen on 17-7-6.
 */
@Service
public class UserService {

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUsers(){

        String sql = "SELECT * FROM user";
        List<User> users = DatabaseHelper.queryEntityList(User.class, sql);

        return users;
    }

    /**
     * 通过id获取单个用户
     */
    public User getById(String id){
        String sql = "SELECT * FROM user WHERE id='" + id + "'";
        User user = DatabaseHelper.queryEntity(User.class, sql);

        return user;
    }

    /**
     * 通过邮箱获取单个用户
     */
    public User getByMail(String mail){
        String sql = "SELECT * FROM user WHERE mail='" + mail + "'";
        User user = DatabaseHelper.queryEntity(User.class, sql);

        return user;
    }

    /**
     * 添加用户
     * @return
     */
    public boolean createUser(Map<String, Object> fieldMap){
        return DatabaseHelper.insertEntity(User.class, fieldMap);
    }

    /**
     * 更新用户
     */
    public boolean updateUser(String id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(User.class, id, fieldMap);
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(String id){
        return DatabaseHelper.deleteEntity(User.class, id);
    }

    /**
     * 修改用户头像
     */
    public boolean updateHeadImage(String id, FileParam fileParam) {
        String path = ServletHelper.getServletContext().getRealPath("/asset/head_image/");

        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("head_image", "/asset/head_image/" + fileParam.getFileName());

        boolean result = DatabaseHelper.updateEntity(User.class, id, fieldMap);

        if (result) {
            UploadHelper.uploadFile(path, fileParam);
        }

        return result;
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
