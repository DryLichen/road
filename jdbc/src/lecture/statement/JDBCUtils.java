package lecture.statement;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接相关工具类
 */
public class JDBCUtils {
    /**
     *  获取connection
     */
    public static Connection getConnection() throws Exception{
        //1.读取配置文件
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");

        //2.加载并注册驱动
        Class.forName(driver);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static Connection getConnection1() throws Exception {
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        return ds.getConnection();
    }

    /**
     * 关闭数据库多种资源
     */
    public static void closeResource(Connection conn, Statement st) {
        try{
            if(st != null){
                st.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement st, ResultSet r) {
        try {
            if(r != null){
                r.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            if(st != null){
                st.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
