import xml.demo01.Book;
import xml.demo01.Orders;
import xml.demo01.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.dao.UserService;

public class Demo01Test {
    @Test
    void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    void testBook1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    void testOrders(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
    }

    @Test
    void testBook2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book02", Book.class);
        System.out.println(book);
    }

    @Test
    void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.add();
    }
}
