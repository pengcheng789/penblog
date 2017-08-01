package top.pengcheng789.java.penblog.security.exception;

/**
 * 认证异常（当非法访问时抛出）
 *
 * CreateDate:2017-08-01
 *
 * @author pen
 */
public class AuthcException extends Exception{

    public AuthcException(){
        super();
    }

    public AuthcException(String message) {
        super(message);
    }

    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
