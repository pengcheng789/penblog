package top.pengcheng789.java.penblog.service;

import top.pengcheng789.java.penblog.model.PassageCategory;
import top.pengcheng789.java.penblog.util.DatabaseUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by pen on 17-7-19.
 */
public class PassageService {
    private static PassageService instance;

    /**
     * Just make the method be privatized.
     */
    private PassageService(){}

    /**
     * 返回这个类的实例。
     * @return
     */
    public static PassageService getInstance(){
        if (instance == null){
            instance = new PassageService();
        }

        return instance;
    }

    /**
     * 添加分类
     */
    public void createCategory(Map<String, Object> fieldMap){
        DatabaseUtil.setTableName("passage_category");
        DatabaseUtil.insertEntity(PassageCategory.class, fieldMap);
    }

    /**
     * 获取分类列表
     */
    public List<PassageCategory> getCategories(){
        String sql = "SELECT * FROM passage_category";
        List<PassageCategory> categories = DatabaseUtil
                .queryEntityList(PassageCategory.class, sql);

        return categories;
    }
}
