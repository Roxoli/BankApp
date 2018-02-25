package webapp.bankapp.domian;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ConstantTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BankAccount bankAccount;

    private String accountNumber;
    private Date date;
    private BigDecimal transaction;
    private String adress;
    private String String;

    public Long getId() {
        return id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public java.lang.String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTransaction() {
        return transaction;
    }

    public void setTransaction(BigDecimal transaction) {
        this.transaction = transaction;
    }

    public java.lang.String getAdress() {
        return adress;
    }

    public void setAdress(java.lang.String adress) {
        this.adress = adress;
    }

    public java.lang.String getString() {
        return String;
    }

    public void setString(java.lang.String string) {
        String = string;
    }
}
