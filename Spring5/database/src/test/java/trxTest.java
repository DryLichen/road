import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.bean.Account;
import transaction.service.UserService;

public class trxTest {
    @Test
    void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService service = context.getBean("userService", UserService.class);

        Account account1 = new Account();
        account1.setUser("Lucy");
        account1.setBalance(50000);

        Account account2 = new Account();
        account2.setUser("Jack");
        account2.setBalance(5000);

        service.add(account1);
        service.add(account2);
    }

    @Test
    void testTransfer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService service = context.getBean("userService", UserService.class);

        Account account1 = new Account();
        account1.setUser("Lucy");
        account1.setBalance(50000);

        Account account2 = new Account();
        account2.setUser("Jack");
        account2.setBalance(5000);

        service.transfer(account1, account2, 5000);
    }
}
