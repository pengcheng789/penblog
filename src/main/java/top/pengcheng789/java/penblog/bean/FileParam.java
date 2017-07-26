package top.pengcheng789.java.penblog.bean;

import java.io.InputStream;

/**
 * 封装上传文件参数
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public class FileParam {

    private String fieldName;
    private String fileName;
    private long fielSize;
    private String contentType;
    private InputStream inputStream;

    public FileParam(String fieldName, String fileName, long fileSize,
                     String contentType, InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fielSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFielSize() {
        return fielSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
