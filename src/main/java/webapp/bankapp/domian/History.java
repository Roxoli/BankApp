package webapp.bankapp.domian;

import lombok.*;
import org.hibernate.annotations.Cascade;

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
    private String adress;
    private String description;

    @ManyToOne
    private BankAccount bankAccount;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
}
