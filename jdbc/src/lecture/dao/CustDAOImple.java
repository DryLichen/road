package lecture.dao;

import lecture.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustDAOImple extends BaseDAO implements CustomersDAO {

    @Override
    public void insert(Connection connection, Customers customers) {
        String sql = "insert into customers(name, email, birth) values(?,?,?)";
        update(connection, sql, customers.getName(), customers.getEmail(), customers.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void update(Connection connection, Customers customers) {
        String sql = "update customers set name = ?, email = ?, birth = ?";
        update(connection, sql, customers.getName(), customers.getEmail(), customers.getBirth());
    }

    @Override
    public Customers getCustomersById(Connection connection, int id) throws ClassNotFoundException {
        String sql = "select id, name, email, birth from customers where id = ?";
        return (Customers) retrieve(connection, Class.forName("lecture.bean.Customers"), sql, id);
    }

    @Override
    public List<Customers> getAll(Connection connection) throws ClassNotFoundException {
        String sql = "select id, name, email, birth from customers";
        ArrayList<Customers> list = (ArrayList<Customers>) getResList(connection, Class.forName("lecture.bean.Customers"), sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection, sql);
    }

    @Override
    public LocalDate getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return ((Date) getValue(connection, sql)).toLocalDate();
    }
}
