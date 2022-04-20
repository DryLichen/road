package lecture.dao;

import lecture.bean.Customers;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

//用于规范针对Customers表的操作
public interface CustomersDAO {
    //添加cust数据
    void insert(Connection connection, Customers customers);

    //通过id删除数据
    void deleteById(Connection connection, int id);

    //更新数据
    void update(Connection connection, Customers customers);

    Customers getCustomersById(Connection connection, int id) throws ClassNotFoundException;

    //查询表中所有数据
    List<Customers> getAll(Connection connection) throws ClassNotFoundException;

    //查询表中有多少条记录
    Long getCount(Connection connection);

    //查询最大生日
    LocalDate getMaxBirth(Connection connection);
}
