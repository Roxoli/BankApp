package webapp.bankapp.domian;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")
    public Set<ConstantTransaction> constantTransaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")
    private Set<History> history;

}
