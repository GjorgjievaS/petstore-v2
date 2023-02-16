package task.java.petstorejpa.repository.InMemory;


import task.java.petstorejpa.model.Transaction;

import java.util.List;
import java.util.Optional;


public interface TransactionRepository {

    int insertTransaction(Transaction transaction);

    List<Transaction> selectAllTransactions();

    Optional<Transaction> selectTransactionById(Long id);

    int deleteTransactionById(Long id);

    int updateTransactionById(Long id,Transaction transaction);
}
