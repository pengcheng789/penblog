package top.pengcheng789.java.penblog.controller;

import top.pengcheng789.java.penblog.annotation.Action;
import top.pengcheng789.java.penblog.annotation.Controller;
import top.pengcheng789.java.penblog.annotation.Inject;
import top.pengcheng789.java.penblog.bean.Data;
import top.pengcheng789.java.penblog.bean.Param;
import top.pengcheng789.java.penblog.bean.View;
import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UserService;

import java.util.List;

/**
 * 处理用户管理相关请求
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
@Controller
public class UserController {

    @Inject
    private UserService userService;

    /**
     * 用户列表界面
     */
    @Action("get:/user/list")
    public View list(Param param){
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
    public View register(Param param){
       return new View("user/register.jsp");
    }

    /**
     * 用户注册提交
     */
    @Action("post:/user/register")
    public Data registerSubmit(Param param){
        //TODO 完成用户注册提交请求
        return null;
    }

    /**
     * 用户信息更新
     */
    @Action("put:/user/profile")
    public Data userUpdate(Param param){
        //TODO 完成用户信息更新请求
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
}
