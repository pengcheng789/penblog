package top.pengcheng789.java.penblog.bean;

/**
 * 数据对象
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public class Data <T> {

    /**
     * 模型数据
     */
    private T model;

    public Data(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }
}
