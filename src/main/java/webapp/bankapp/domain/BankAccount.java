package webapp.bankapp.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    @NotNull
    @Size(min=2)
    private String login;

    @NotNull
    @Size(min=8)
    private String password;

    @NotNull
    @Size(min=2)
    private String firstName;

    @NotNull
    @Size(min=2)
    private String lastName;

    @NotNull
    @Size(min=2)
    private String town;

    @NotNull
    @Size(min=2)
    private String address;

    @NotNull
    @Size(min=2)
    private String email;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")
    public Set<ConstantTransaction> constantTransaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")
    private Set<History> history;

}
