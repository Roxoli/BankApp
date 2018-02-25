package webapp.bankapp.domian;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ConstantTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private Date date;
    private BigDecimal transaction;
    private String adress;
    private String String;

    @ManyToOne
    private BankAccount bankAccount;

}
