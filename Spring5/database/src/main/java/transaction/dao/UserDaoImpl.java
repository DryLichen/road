package transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import transaction.bean.Account;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public int add(Account account) {
        String sql = "insert into spring5_account values (?,?)";
        return template.update(sql, account.getUser(), account.getBalance());
    }

    @Override
    public int update(Account account) {
        String sql = "update spring5_account set balance = ? where user = ?";
        return template.update(sql, account.getBalance(), account.getUser());
    }
}
