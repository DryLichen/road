package lecture.dao;

import lecture.bean.Customers;
import lecture.statement.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class CustTest {
    private CustDAOImple dao = new CustDAOImple();

    @Test
    void testGetMaxBirth() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(dao.getMaxBirth(connection));
    }

    @Test
    void testGetCount() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(dao.getCount(connection));
    }

    @Test
    void testInsert() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        Customers customers = new Customers();
        customers.setId(1);
        customers.setName("尚硅谷");
        customers.setBirth(Date.valueOf("2000-01-01"));
        customers.setEmail("1111100000@qq.com");
        dao.insert(connection, customers);
    }

    @Test
    void testDeleteById() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        dao.deleteById(connection, 23);
    }

    @Test
    void testGetAll() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        dao.getAll(connection).forEach(System.out::println);
    }

    @Test
    void testGetCustomersById() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(dao.getCustomersById(connection, 1));
    }
}
