package jdbctemplate.dao;

import jdbctemplate.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public int add(Book book) {
        String sql = "insert into spring5_book(name, author) values (?,?)";
        return template.update(sql, book.getName(), book.getAuthor());
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from spring5_book where id = ?";
        return template.update(sql, id);
    }

    @Override
    public int update(Book book) {
        String sql = "update spring5_book set name = ?, author = ? where name = ?";
        return template.update(sql, book.getName(), book.getAuthor(), book.getName());
    }

    @Override
    public Book retrieveById(Integer id) throws ClassNotFoundException {
        String sql = "select * from spring5_book where id = ?";
        return (Book) template.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    @Override
    public List<Book> retrieveList() {
        String sql = "select * from spring5_book";
        return template.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from spring5_book";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public int[] addBatch(List<Object[]> batchArgs) {
        String sql= "insert into spring5_book(name, author) values (?,?)";
        return template.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] updateBatch(List<Object[]> batchArgs) {
        String sql = "update spring5_book set name = ?, author = ? where id = ?";
        return template.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] deleteBatch(List<Object[]> batchArgs) {
        String sql = "delete from spring5_book where id = ?";
        return template.batchUpdate(sql, batchArgs);
    }
}
