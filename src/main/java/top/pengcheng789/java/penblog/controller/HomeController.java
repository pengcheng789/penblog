package top.pengcheng789.java.penblog.controller;

import top.pengcheng789.java.penblog.annotation.Action;
import top.pengcheng789.java.penblog.annotation.Controller;
import top.pengcheng789.java.penblog.bean.Param;
import top.pengcheng789.java.penblog.bean.View;

/**
 * 首页控制器
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
@Controller
public class HomeController {

    /**
     * 首页界面
     */
    @Action("get:/")
    public View index(){
        return new View("common/home.jsp");
    }

    @Action("get:/home")
    public View home(){
        return index();
    }
}
