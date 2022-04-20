import xml.otherbean.auto.Empl;
import xml.otherbean.life.Person;
import xml.bean.Employee;
import xml.collection.Book;
import xml.collection.Student;
import xml.otherbean.factory.Course;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OtherTest {
    @Test
    void testEmployee(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    @Test
    void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    void testFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    void testLife(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println("第四步，获取bean实例");
        System.out.println(person);
        context.close();
    }

    @Test
    void testAuto(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Empl empl = context.getBean("empl", Empl.class);
        System.out.println(empl);
    }
}
