import aspectJ.Book;
import aspectJ.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {

    @Test
    void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJ.xml");
        User proxy =  context.getBean("user", User.class);
        proxy.user();
    }

    @Test
    void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book proxy =  context.getBean("book", Book.class);
        proxy.read();
    }
}
