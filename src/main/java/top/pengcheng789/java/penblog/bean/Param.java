package top.pengcheng789.java.penblog.bean;

import top.pengcheng789.java.penblog.util.CastUtil;

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
     * 获取 String 类型的值
     */
    public String getString(String name) {
        return CastUtil.castString(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
