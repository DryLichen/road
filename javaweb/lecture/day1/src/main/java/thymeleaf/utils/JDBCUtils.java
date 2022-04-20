package thymeleaf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection2() throws Exception {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdnc.properties");
        Properties p = new Properties();
        p.load(is);

        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String dirverClassName = p.getProperty("driverClassName");

        Class.forName(dirverClassName);

        Connection connection = DriverManager.getConnection(url, username,password);
        return connection;
    }

    public static Connection getConnection() throws Exception {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    public static void closeResources(Connection conn, Statement stat){
        try{
            if(stat != null){
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            if(conn != null){
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResources(Connection conn, Statement stat, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            if(stat != null){
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            if(conn != null){
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
