package lecture.util;

import lecture.bean.Customers;
import lecture.statement.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DbutilsTest {
    @Test
    void testUpdate1() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        int count = qr.update(conn, sql, "何成飞", "he@qq.com", "1992-09-08");

        System.out.println("共插入了" + count + "条记录");
        DbUtils.close(conn);
    }

    @Test
    void testUpdate2() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "delete from customers where id = ?";
        int count = qr.update(conn, sql, 25);

        System.out.println("delete total number: " + count);
        DbUtils.close(conn);
    }

    @Test
    void testBeanHandler() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "select id,name,email,birth from customers where id = ?";

        BeanHandler<Customers> handler = new BeanHandler<Customers>(
                (Class<? extends Customers>) Class.forName("lecture.bean.Customers"));

        Customers cust = runner.query(conn, sql, handler, 1);
        System.out.println(cust);
        DbUtils.close(conn);
    }

    @Test
    void testBeanListHandler() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "select id,name,email,birth from customers where id < ?";

        BeanListHandler<Customers> handler = new BeanListHandler<Customers>((Class<? extends Customers>) Class.forName("lecture.bean.Customers"));
        List<Customers> list = runner.query(conn, sql, handler, 5);
        list.forEach(System.out::println);
        DbUtils.close(conn);
    }

    //自定义类
    @Test
    void testMine() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "select id,name,email,birth from customers where id = ?";

        ResultSetHandler<Customers> handler = new ResultSetHandler<Customers>() {
            @Override
            public Customers handle(ResultSet rs) throws SQLException {
                System.out.println("handle");

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    Date birth = rs.getDate("birth");

                    return new Customers(id, name, email, birth);
                }

                return null;
            }
        };

        Customers cust = runner.query(conn, sql, handler, 1);
        System.out.println(cust);
        DbUtils.close(conn);
    }

    //组函数
    @Test
    void testScalar() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql = "select count(*) from customers";

        ScalarHandler handler = new ScalarHandler();
        long count = (long)runner.query(conn, sql, handler);
        System.out.println(count);
        DbUtils.close(conn);
    }
}
