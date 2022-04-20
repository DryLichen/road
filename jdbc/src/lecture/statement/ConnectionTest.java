package lecture.statement;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.Properties;

public class ConnectionTest {

    //非常low
    @Test
    void testConnection1() throws SQLException{
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "19991111@Zsr");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //比较low，使用反射,使得程序不出现第三方api，具有可移植性
    @Test
    void testConnection2() throws Exception {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Constructor constructor = clazz.getDeclaredConstructor();
        Driver driver = (Driver) constructor.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "19991111@Zsr");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    //一般
    @Test
    void testConnection3() throws Exception{
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "19991111@Zsr");

        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Constructor constructor = clazz.getDeclaredConstructor();
        Driver driver = (Driver) constructor.newInstance();
        DriverManager.registerDriver(driver);

        Connection conn = DriverManager.getConnection(url, info);
        System.out.println(conn);
    }

    //还行,省略了注册驱动
    @Test
    void testConnection4() throws Exception{
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "19991111@Zsr");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, info);
        System.out.println(conn);
    }

    //挺好。读取配置文件，实现了数据与代码的解耦
    @Test
    void testConnection5() throws Exception{
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
