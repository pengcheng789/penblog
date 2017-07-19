package top.pengcheng789.java.penblog.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by pen on 17-7-2.
 */
public final class DatabaseUtil {
    /**
     * 通过数据库连接池连接数据库。
     */
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    /**
     * 存放一个实例化的Connection，保证一个线程只存在一个Connection实例。
     */
    private static final ThreadLocal<Connection> CONNECTION_HOLDER
            = new ThreadLocal<Connection>();

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    /**
     * 初始化数据库连接信息
     */
    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");

        DATA_SOURCE.setDriverClassName(driver);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(username);
        DATA_SOURCE.setPassword(password);
    }

    /**
     * 数据表名
     */
    private static String tableName;

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = CONNECTION_HOLDER.get();
        if(connection == null){
            try{
                connection = DATA_SOURCE.getConnection();
            } catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }

        return connection;
    }

    /**
     * 从数据库获取数据，返回一个List<T>数组。
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(
            Class<T> entityClass, String sql, Object... params){
        List<T> entityList;
        try{
            Connection connection = getConnection();
            entityList = QUERY_RUNNER.query(
                    connection, sql,
                    new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return entityList;
    }

    /**
     * 从数据库获取数据，返回一个T实例。
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params){
        T entity;
        try {
            Connection connection = getConnection();
            entity = QUERY_RUNNER.query(connection, sql,
                    new BeanHandler<T>(entityClass), params);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return entity;
    }

    /**
     * 执行查询语句
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... params){
        List<Map<String, Object>> result;

        try {
            Connection connection = getConnection();
            result = QUERY_RUNNER.query(connection, sql,
                    new MapListHandler(), params);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    /**
     * 执行更新语句（包括update,insert,delete）
     */
    public static int executeUpdate(String sql, Object... params){
        int rows = 0;
        try {
            Connection connection = getConnection();
            rows = QUERY_RUNNER.update(connection, sql, params);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return rows;
    }

    /**
     * 插入实体
     */
    public static <T_T> boolean insertEntity(Class<T_T> entityClass,
                                           Map<String, Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)){
            return false;
        }

        String sql = "INSERT INTO " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), columns.length(), ")");
        sql += columns + " VALUES " +values;

        Object[] params = fieldMap.values().toArray();
        return executeUpdate(sql, params) == 1;
    }

    /**
     * 更新实体
     */
    public static <T> boolean updateEntity(Class<T> entityClass,
                                           String id, Map<String, Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)){
            return false;
        }

        String sql = "UPDATE " + getTableName(entityClass) + " SET ";
        StringBuilder columns = new StringBuilder();
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", "))
                + " WHERE id=?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();

        return executeUpdate(sql, params) == 1;
    }

    /**
     * 删除实体
     */
    public static <T> boolean deleteEntity(Class<T> entityClass, String id){
        String sql = "DELETE FROM " + getTableName(entityClass) + " WHERE id=?";
        return executeUpdate(sql, id) == 1;
    }

    /**
     * 可自定义表名。
     * @param name
     */
    public static void setTableName(String name) {
        tableName = name;
    }

    /**
     * 返回tableName的值，
     * 如果tableName为空，
     * 则根据实例类返回表名。
     */
    private static String getTableName(Class<?> entityClass){
        if (tableName == null){
            return entityClass.getSimpleName().toLowerCase();
        } else {
            String temp = tableName;
            tableName = null;
            return temp;
        }
    }

}
