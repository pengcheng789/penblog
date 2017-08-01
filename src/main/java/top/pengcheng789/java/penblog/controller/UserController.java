package top.pengcheng789.java.penblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.pengcheng789.java.penblog.annotation.Action;
import top.pengcheng789.java.penblog.annotation.CheckForm;
import top.pengcheng789.java.penblog.annotation.Controller;
import top.pengcheng789.java.penblog.annotation.Inject;
import top.pengcheng789.java.penblog.bean.Data;
import top.pengcheng789.java.penblog.bean.Param;
import top.pengcheng789.java.penblog.bean.Replier;
import top.pengcheng789.java.penblog.bean.View;
import top.pengcheng789.java.penblog.helper.SecurityHelper;
import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.security.exception.AuthcException;
import top.pengcheng789.java.penblog.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 处理用户管理相关请求
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Inject
    private UserService userService;

    /**
     * 用户列表界面
     */
    @Action("get:/user/list")
    public View list(){
        List<User> users = userService.getUsers();

        return new View("user/list.jsp").addModel("users", users);
    }

    /**
     * 用户个人界面
     */
    @Action("get:/user/profile")
    public View profile(Param param){
        String id = param.getString("id");
        User user = userService.getById(id);

        return new View("user/profile.jsp").addModel("user", user);
    }

    /**
     * 用户注册界面
     */
    @Action("get:/user/register")
    public View register(){
       return new View("user/register.jsp");
    }

    /**
     * 用户注册提交
     */
    @CheckForm("register")
    @Action("post:/user/register")
    public Data registerSubmit(Param param){
        Map<String, Object> fieldMap = param.getFieldMap();
        fieldMap.remove("confirm_password");
        fieldMap.put("id", UUID.randomUUID().toString());
        fieldMap.put("create_date", new Date());

        boolean result = userService.createUser(fieldMap);

        return new Data(new Replier(result));
    }

    /**
     * 用户信息更新
     */
    @Action("put:/user/profile")
    public Data userUpdate(Param param){
        Map<String, Object> fieldMap = param.getFieldMap();
        String id = (String)fieldMap.get("id");

        return null;
    }

    /**
     * 用户信息删除
     */
    @Action("delete:/user/profile")
    public Data userDalate(Param param){
        //TODO 完成用户信息删除
        return null;
    }

    /**
     * 登录界面
     */
    @Action("get:/user/login")
    public View login() {
        return new View("user/login.jsp");
    }

    /**
     * 登录表单提交
     */
    @Action("post:/user/login")
    public View loginSubmit(Param param) {
        String mail = param.getString("mail");
        String password = param.getString("password");

        try {
            SecurityHelper.login(mail, password);
        } catch (AuthcException e) {
            LOGGER.error("login failure", e);
            return new View("/user/login");
        }

        return new View("/user/profile");
    }

    /**
     * 注销请求提交
     */
    @Action("get:/user/logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("/");
    }
}
