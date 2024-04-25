package utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
//定义了一个静态代码块，它在类加载时自动执行。
//该代码块的作用是读取 druid.properties 配置文件中的数据库连接信息，并创建 druidDataSource 数据库连接池
    private static DataSource ds;

    static {
        Properties pro=new Properties();
        try {
            pro.load(new FileInputStream("D:/java文件夹/OnlineBookstore01/src/druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection=null;
        connection= ds.getConnection();;
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement , Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
