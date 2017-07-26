package top.pengcheng789.java.penblog.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 文件操作工具类
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public final class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取真实文件名
     */
    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    /**
     * 创建文件
     */
    public static File createFile(String filePath) {
        File file;

        try {
            file = new File(filePath);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                FileUtils.forceMkdir(parentDir);
            }
        } catch (Exception e) {
            LOGGER.error("create file failure", e);
            throw new RuntimeException(e);
        }

        return file;
    }
}
