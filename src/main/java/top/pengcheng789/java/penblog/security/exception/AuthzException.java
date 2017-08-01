package top.pengcheng789.java.penblog.security.exception;

/**
 * 授权异常（当权限无效时抛出）
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class AuthzException extends RuntimeException {

    public AuthzException() {
        super();
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
