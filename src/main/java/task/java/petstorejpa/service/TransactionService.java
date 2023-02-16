package task.java.petstorejpa.service;

import org.springframework.stereotype.Service;
import task.java.petstorejpa.enumerations.Type;
import task.java.petstorejpa.model.Transaction;
import task.java.petstorejpa.repository.jpa.PetRepositoryJpa;
import task.java.petstorejpa.repository.jpa.TransactionRepositoryJpa;
import task.java.petstorejpa.repository.jpa.UserRepositoryJpa;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TransactionService {

    private final TransactionRepositoryJpa transactionRepository;
    private final PetRepositoryJpa petRepository;
    private final UserRepositoryJpa userRepository;


    public TransactionService(TransactionRepositoryJpa transactionRepository, PetRepositoryJpa petRepository, UserRepositoryJpa userRepository) {
        this.transactionRepository = transactionRepository;
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }
    public Optional<Transaction> addTransaction(Transaction transaction){
        this.transactionRepository.deleteTransactionById(transaction.getId());

        return Optional.of(this.transactionRepository.save(new Transaction(transaction.getExecutionDate(), transaction.getUsersThatBoughtCount(), transaction.getUsersThatDidntBuyCount())));
    }

    public void purchasePets(){

        List<Integer> buyersIndices = new ArrayList<>();

        int purchaseCount=0;
        int notPuchasedCount;

        for (int i=0; i<userRepository.findAll().size();i++){
            for (int j=0;j<petRepository.findAll().size();j++){

                if (petRepository.findAll().get(j).getOwner() != null) continue;

                if (petRepository.findAll().get(j).getPrice() > userRepository.findAll().get(i).getBudget()){

                    continue;
                }

                petRepository.findAll().get(j).setOwner(userRepository.findAll().get(i));

                petRepository.findAll().get(j).setOwnerI(userRepository.findAll().get(i).getId());

                userRepository.findAll().get(i).setBudget(userRepository.findAll().get(i).getBudget() - petRepository.findAll().get(j).getPrice());
                if(!buyersIndices.contains(i)) {
                    purchaseCount++;
                    buyersIndices.add(i);
                }


                if (petRepository.findAll().get(j).getType()== Type.CAT){
                    System.out.printf("Meow, cat %s has owner %s",this.petRepository.findAll().get(i).getName(), this.petRepository.findAll().get(i).getOwner());
                } else {
                    System.out.printf("Woof, dog %s has owner %s",this.petRepository.findAll().get(i).getName(), this.petRepository.findAll().get(i).getOwner());

                }
            }
        }

        notPuchasedCount=userRepository.findAll().size()-purchaseCount;
        Transaction transaction=new Transaction(new Date(),purchaseCount,notPuchasedCount);
        this.addTransaction(transaction);
    }

    public List<Transaction> getAllTransactions(){
        return this.transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return this.transactionRepository.findTransactionById(id);
    }

    @Transactional
    public int deleteTransaction(Long id){
        return this.transactionRepository.deleteTransactionById(id);
    }

}

