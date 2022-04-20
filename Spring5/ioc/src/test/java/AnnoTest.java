import annotation.Config;
import annotation.UserDao;
import annotation.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoTest {

    @Test
    void testUser1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnno.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.add();
    }

    @Test
    void testUser2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService service = context.getBean("userService", UserService.class);
        service.add();
    }
}
