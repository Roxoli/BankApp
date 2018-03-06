package webapp.bankapp.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private Date date;
    private BigDecimal transaction;
    private String address;
    private String description;

    @ManyToOne
    private BankAccount bankAccount;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
}
