package jdbctemplate.service;

import jdbctemplate.bean.Book;
import jdbctemplate.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        int count = bookDao.add(book);
        System.out.println("添加了" + count + "条数据");
    }

    public void deleteBook(Integer id){
        int count = bookDao.deleteById(id);
        System.out.println("删除了" + count + "条数据");
    }

    public void updateBook(Book book){
        int count = bookDao.update(book);
        System.out.println("更新了" + count + "条数据");
    }

    public void retrieveBook(Integer id){
        try {
            Book book = bookDao.retrieveById(id);
            System.out.println(book);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void retrieveListBook(){
        List<Book> bookList = bookDao.retrieveList();
        System.out.println(bookList);
    }

    public void countBook(){
        int count = bookDao.selectCount();
        System.out.println("一共有" + count + "条数据");
    }

    public void addBook(List<Object[]> args){
        int[] counts = bookDao.addBatch(args);
        System.out.println(Arrays.toString(counts));
    }

    public void updateBook(List<Object[]> args){
        int[] counts = bookDao.updateBatch(args);
        System.out.println(Arrays.toString(counts));
    }

    public void deleteBook(List<Object[]> args){
        int[] counts = bookDao.deleteBatch(args);
        System.out.println(Arrays.toString(counts));
    }
}
