package task.java.petstorejpa.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.java.petstorejpa.model.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepositoryJpa extends JpaRepository<Transaction, Long> {
    List<Transaction> findAll();
    Optional<Transaction> findTransactionById(Long id);
    int deleteTransactionById(Long id);
}
