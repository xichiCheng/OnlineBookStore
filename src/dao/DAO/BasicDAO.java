package dao.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO <T>{
    QueryRunner qr= new QueryRunner();
    public int update(String sql,Object... parameters) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        int row = qr.update(connection,sql,parameters);
        JDBCUtils.close(null,null,connection);
        return row;
    }

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) throws SQLException {
        Connection connection=JDBCUtils.getConnection();
        List<T> list=qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        JDBCUtils.close(null,null,connection);
        return list;
    }

    public T querySingle(String sql,Class<T> clazz,Object... parameters) throws SQLException {
        Connection connection=JDBCUtils.getConnection();
        T list=qr.query(connection,sql, new BeanHandler<>(clazz),parameters);
        JDBCUtils.close(null,null,connection);
        return list;
    }

    public Object quireScalar(String sql,Object... parameters) throws SQLException {
        Connection connection=JDBCUtils.getConnection();
        Object list=qr.query(connection,sql,new ScalarHandler(),parameters);
        JDBCUtils.close(null,null,connection);
        return list;
    }

}

