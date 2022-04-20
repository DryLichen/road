package xml.otherbean.life;

import org.springframework.beans.factory.FactoryBean;
import xml.otherbean.factory.Course;

//演示工厂Bean
public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("Spring5");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
