package thymeleaf.dao;

import thymeleaf.bean.Fruit;

import java.sql.Connection;
import java.util.List;

public interface FruitDAO {
    List<Fruit> getFruitList(Connection connection) throws ClassNotFoundException;
}
