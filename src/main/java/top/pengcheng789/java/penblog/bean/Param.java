package top.pengcheng789.java.penblog.bean;

import java.util.Map;

/**
 * 请求参数对象
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
