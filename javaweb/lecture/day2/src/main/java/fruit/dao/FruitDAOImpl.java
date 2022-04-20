package fruit.dao;

import fruit.bean.Fruit;
import myssm.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FruitDAOImpl implements FruitDAO {
    @Override
    public int addFruit(Connection conn, Fruit fruit) throws SQLException {
        String sql = "insert into t_fruit(fname, price, fcount, remark) values (?,?,?,?)";
        QueryRunner runner = new QueryRunner();
        return runner.update(conn, sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }

    @Override
    public int delFruitById(Connection conn, Integer fid) throws SQLException {
        String sql = "delete from t_fruit where fid = ?";
        QueryRunner runner = new QueryRunner();
        return runner.update(conn, sql, fid);
    }

    @Override
    public int updateFruit(Connection conn, Fruit fruit) throws SQLException {
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        QueryRunner runner = new QueryRunner();
        return runner.update(conn, sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public Fruit getFruitById(Connection conn, Integer fid) throws SQLException, ClassNotFoundException {
        String sql = "select * from t_fruit where fid = ?";

        QueryRunner runner = new QueryRunner();
        BeanHandler<Fruit> handler = new BeanHandler<>((Class<? extends Fruit>) Class.forName("fruit.bean.Fruit"));
        Fruit fruit = runner.query(conn, sql, handler, fid);

        return fruit;
    }

    @Override
    public List<Fruit> getFruitList(Connection conn, Integer pageNo, String keyword) throws ClassNotFoundException, SQLException {
        String sql = "select * from t_fruit where fname like ? or remark like ? limit ?, 5";

        QueryRunner runner = new QueryRunner();
        BeanListHandler<Fruit> handler = new BeanListHandler<>((Class<? extends Fruit>) Class.forName("fruit.bean.Fruit"));
        List<Fruit> fruitList = runner.query(conn, sql, handler, "%" + keyword +"%", "%" + keyword +"%",(pageNo-1)*5);

        return fruitList;
    }

    @Override
    public int getTotalCount(Connection conn, String keyword) throws SQLException {
        String sql = "select count(*) from t_fruit where fname like ? or remark like ?";

        QueryRunner runner = new QueryRunner();
        ScalarHandler handler = new ScalarHandler();
        Long count1 = (Long) runner.query(conn, sql, handler, "%" + keyword + "%", "%" + keyword + "%");
        int count = count1.intValue();

        return count;
    }
}
