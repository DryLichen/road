import jdbctemplate.bean.Book;
import jdbctemplate.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

    @Test
    void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setName("Arrival");
        book.setAuthor("姜峯楠");
        service.addBook(book);
    }

    @Test
    void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setName("Arrival");
        book.setAuthor("Tedd Chiang");
        service.updateBook(book);
    }

    @Test
    void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.deleteBook(9);
    }

    @Test
    void testRetrieve(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.retrieveBook(8);
    }

    @Test
    void testRetrieveList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.retrieveListBook();
    }

    @Test
    void testCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.countBook();
    }

    @Test
    void testBatchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"vail","Maugham"};
        Object[] o2 = {"城堡", "卡夫卡"};
        args.add(o1);
        args.add(o2);
        service.addBook(args);
    }

    @Test
    void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"vails","Maugham", 13};
        Object[] o2 = {"城堡", "卡夫卡饼干", 12};
        args.add(o1);
        args.add(o2);
        service.updateBook(args);
    }

    @Test
    void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService service = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {12};
        Object[] o2 = {13};
        args.add(o1);
        args.add(o2);
        service.deleteBook(args);
    }
}
