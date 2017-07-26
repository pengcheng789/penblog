package top.pengcheng789.java.penblog.bean;

/**
 * 封装表单参数
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public class FormParam {

    private String fieldName;
    private Object fieldValue;

    public FormParam(String fieldName, Object fieldValue){
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
