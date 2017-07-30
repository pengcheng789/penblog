package top.pengcheng789.java.penblog.bean;

/**
 * 回复数据
 *
 * CreateDate:2017-07-29
 *
 * @author pen
 */
public class Replier {

    private Boolean result;
    private String field;
    private String message;

    public Replier(Boolean result) {
        this(result, "", "");
    }

    public Replier(Boolean result, String field, String message) {
        this.result = result;
        this.field = field;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
