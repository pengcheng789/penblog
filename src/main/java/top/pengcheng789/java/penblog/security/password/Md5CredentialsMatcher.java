package top.pengcheng789.java.penblog.security.password;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import top.pengcheng789.java.penblog.util.CodecUtil;

/**
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class Md5CredentialsMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token,
                                      AuthenticationInfo info) {
        String submitted = String.valueOf(((UsernamePasswordToken)token).getPassword());
        String encrypted = String.valueOf(info.getCredentials());
        return CodecUtil.md5(submitted).equals(encrypted);
    }
}
