package thymeleaf.dao;

import thymeleaf.bean.Fruit;
import thymeleaf.myssm.BaseDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList(Connection connection) throws ClassNotFoundException {
        String sql = "select * from t_fruit";
        return (List<Fruit>) getList(connection, Class.forName("thymeleaf.bean.Fruit"), sql);
    }
}
