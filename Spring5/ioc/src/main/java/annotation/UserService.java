package annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Resource(name = "userDaoImpl")
//    private UserDao userDao;

    private final UserDao userDao;

    public UserService(@Qualifier(value = "userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service adding... ...");
        userDao.add();
    }
}
