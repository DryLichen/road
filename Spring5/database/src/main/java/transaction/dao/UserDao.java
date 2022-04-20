package transaction.dao;

import transaction.bean.Account;

public interface UserDao {
    public int add(Account account);

    public int update(Account account);
}
