package transaction.bean;

public class Account {
    private String user;
    private int balance;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", balance=" + balance +
                '}';
    }
}
