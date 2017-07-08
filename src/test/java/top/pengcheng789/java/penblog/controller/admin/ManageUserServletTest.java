package top.pengcheng789.java.penblog.controller.admin;

import org.junit.Test;
import top.pengcheng789.java.penblog.model.User;
import top.pengcheng789.java.penblog.service.UserService;

import java.util.List;

/**
 * Created by pen on 17-7-6.
 */
public class ManageUserServletTest {
    @Test
    public void showUserCrateDate(){
        List<User> users = UserService.getInstance().getUsers();

        for(User user : users){
            System.out.println(user.getCreate_date().toString());
        }
    }
}
