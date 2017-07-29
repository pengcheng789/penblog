package top.pengcheng789.java.penblog.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.pengcheng789.java.penblog.annotation.CheckForm;
import top.pengcheng789.java.penblog.bean.Data;
import top.pengcheng789.java.penblog.bean.Param;
import top.pengcheng789.java.penblog.bean.Replier;
import top.pengcheng789.java.penblog.service.UserService;
import top.pengcheng789.java.penblog.util.StringUtil;

import java.lang.reflect.Method;

/**
 * CreateDate:2017-07-28
 *
 * @author pen
 */
public class CheckFormProxy implements Proxy {

    private UserService userService = new UserService();

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckFormProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Method method = proxyChain.getTargetMethod();

        if (method.isAnnotationPresent(CheckForm.class)) {
            Object[] params = proxyChain.getMethodParams();
            Param param = (Param) params[0];
            CheckForm checkForm = method.getAnnotation(CheckForm.class);
            String formType = checkForm.value();

            if (StringUtil.isNotEmpty(formType)) {
                if (formType.equals("register")) {
                    Replier replier = checkRegisterForm(param);

                    if (!replier.getResult()) {
                        result = new Data(replier);
                    } else {
                        result = proxyChain.doProxyChain();
                    }
                }

            }
        } else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }

    private Replier checkRegisterForm(Param param) {
        Replier replier;

        String mail = param.getString("mail");
        if (StringUtil.isEmpty(mail)) {
            replier = new Replier(false, "mail", "邮箱不能为空");
            return replier;
        }
        if (StringUtil.isNotEmpty(mail)) {
            boolean result = userService.isMailNotExist(mail);

            if (!result) {
                replier = new Replier(result, "mail", "邮箱已被注册");
                return replier;
            }
        }

        String nickname = param.getString("nickname");
        if (StringUtil.isEmpty(nickname)) {
            replier = new Replier(false, "nickname", "昵称不能为空");
            return replier;
        }

        String password = param.getString("password");
        if (StringUtil.isEmpty(password)) {
            replier = new Replier(false, "password", "密码不能为空");
            return replier;
        }
        if (password.length() < 6) {
            replier = new Replier(false, "password", "密码长度不能低于6位");
            return replier;
        }

        String confirmPassword = param.getString("confirm_password");
        if (!confirmPassword.equals(password)) {
            replier = new Replier(false, "password", "两次密码不一样");
            return replier;
        }

        String sex = param.getString("sex");
        if (!(sex.equals("男") || sex.equals("女"))) {
            replier = new Replier(false, "sex", "性别必须是男或女");
            return replier;
        }

        replier = new Replier(true);

        LOGGER.error("checked register form failure.");
        return replier;
    }
}
