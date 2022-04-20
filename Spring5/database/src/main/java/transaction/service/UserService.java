package transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transaction.bean.Account;
import transaction.dao.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void add(Account account){
        int count = userDao.add(account);
        System.out.println("添加了" + count + "条数据");
    }

//    @Transactional(readOnly = false, timeout = -1, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public void transfer(Account account1, Account account2, int value){
//        try{
            // 1.开启事务

            // 2.进行事务操作
            account1.setBalance(account1.getBalance() - value);
            userDao.update(account1);

            // 模拟异常发生
            int a = 10/0;

            account2.setBalance(account2.getBalance() + value);
            userDao.update(account2);

            // 3.提交事务

//        } catch (Exception e){
//            // 4.若失败，事务回滚
//        }

    }
}
