package webapp.bankapp.domian;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    public Set<ConstantTransaction> constantTransaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    private Set<History> history;

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<ConstantTransaction> getConstantTransaction() {
        return constantTransaction;
    }

    public void setConstantTransaction(Set<ConstantTransaction> constantTransaction) {
        this.constantTransaction = constantTransaction;
    }

    public Set<History> getHistory() {
        return history;
    }

    public void setHistory(Set<History> history) {
        this.history = history;
    }
}
