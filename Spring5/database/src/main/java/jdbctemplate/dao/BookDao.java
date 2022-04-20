package jdbctemplate.dao;

import jdbctemplate.bean.Book;

import java.util.List;

public interface BookDao {
    public int add(Book book);

    public int deleteById(Integer id);

    public int update(Book book);

    public Book retrieveById(Integer id) throws ClassNotFoundException;

    public List<Book> retrieveList();

    public int selectCount();

    //批量处理测试
    public int[] addBatch(List<Object[]> batchArgs);

    public int[] updateBatch(List<Object[]> batchArgs);

    public int[] deleteBatch(List<Object[]> batchArgs);
}
