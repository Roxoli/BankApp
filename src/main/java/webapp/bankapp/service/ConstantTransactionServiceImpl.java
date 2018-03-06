package webapp.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.bankapp.domain.ConstantTransaction;
import webapp.bankapp.repository.ConstantTransactionRepository;

@Service
public class ConstantTransactionServiceImpl implements ConstantTransactionService {

    private ConstantTransactionRepository constantTransactionRepository;

    @Autowired
    public ConstantTransactionServiceImpl(ConstantTransactionRepository constantTransactionRepository) {
        this.constantTransactionRepository = constantTransactionRepository;
    }

    @Override
    public ConstantTransaction addTransaction(ConstantTransaction constantTransaction) {
        return constantTransactionRepository.save(constantTransaction);
    }
}
