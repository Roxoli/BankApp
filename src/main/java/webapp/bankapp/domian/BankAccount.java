package webapp.bankapp.domian;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    public ConstantTransaction constantTransaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    private History history;

    private String accountNumber;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConstantTransaction getConstantTransaction() {
        return constantTransaction;
    }

    public void setConstantTransaction(ConstantTransaction constantTransaction) {
        this.constantTransaction = constantTransaction;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
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
}
