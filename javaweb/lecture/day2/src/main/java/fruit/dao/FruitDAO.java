package fruit.dao;

import fruit.bean.Fruit;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FruitDAO {
    int addFruit(Connection connection, Fruit fruit) throws SQLException;

    int delFruitById(Connection connection, Integer fid) throws SQLException;

    int updateFruit(Connection connection, Fruit fruit) throws SQLException;

    Fruit getFruitById(Connection connection, Integer fid) throws SQLException, ClassNotFoundException;

    List<Fruit> getFruitList(Connection connection, Integer pageNo, String keyword) throws ClassNotFoundException, SQLException;

    int getTotalCount(Connection connection, String keyword) throws SQLException;
}
