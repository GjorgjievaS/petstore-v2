package task.java.petstorejpa.webapi;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import task.java.petstorejpa.model.Transaction;
import task.java.petstorejpa.service.TransactionService;

import java.util.List;


@RequestMapping("/api/purchase")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping            //@Valid
    public void addTransaction(@NonNull @RequestBody Transaction transaction) {
        this.transactionService.addTransaction(transaction);
    }

    @PostMapping(path = "/buy")
    public void purchase() {
        this.transactionService.purchasePets();
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return  this.transactionService.getAllTransactions();
    }

    @GetMapping(path = "{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return this.transactionService.getTransactionById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTransactionById(@PathVariable Long id) {
        this.transactionService.deleteTransaction(id);
    }

    @PutMapping(path = "{id}")                              //@Valid
    public void updateTransaction(@PathVariable Long id, @NonNull @RequestBody Transaction transaction) {
        this.transactionService.addTransaction(transaction);
    }
}
