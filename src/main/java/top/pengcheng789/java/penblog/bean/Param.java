package top.pengcheng789.java.penblog.bean;

import top.pengcheng789.java.penblog.util.CastUtil;
import top.pengcheng789.java.penblog.util.CollectionUtil;
import top.pengcheng789.java.penblog.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数对象
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public class Param {

    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList){
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    /**
     * 获取请求参数映射
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<String, Object>();

        if (CollectionUtil.isNotEmpty(formParamList)) {
            for (FormParam formParam : formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();

                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR
                            + fieldValue;
                }

                fieldMap.put(fieldName, fieldValue);
            }
        }

        return fieldMap;
    }

    /**
     * 获取上传文件映射
     */
    public Map<String, List<FileParam>> getFileMap(){
        Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();

        if (CollectionUtil.isNotEmpty(fileParamList)) {
            for (FileParam fileParam : fileParamList) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParamList;

                if (fileMap.containsKey(fieldName)) {
                    fileParamList = fileMap.get(fieldName);
                } else {
                    fileParamList = new ArrayList<FileParam>();
                }

                fileParamList.add(fileParam);
                fileMap.put(fieldName, fileParamList);
            }
        }

        return fileMap;
    }

    /**
     * 获取某个字段的所有上传文件
     */
    public List<FileParam> getFileList(String fieldName) {
        return getFileMap().get(fieldName);
    }

    /**
     * 获取某个字段的唯一上传文件
     */
    public FileParam getFile(String fieldName) {
        List<FileParam> fileParamList = getFileList(fieldName);

        if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }

        return null;
    }

    /**
     * 验证参数是否为空
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParamList) &&
                CollectionUtil.isEmpty(fileParamList);
    }

    /**
     * 根据参数名获取 String 型参数
     */
    public String getString(String name) {
        return CastUtil.castString(getFieldMap().get(name));
    }
}
