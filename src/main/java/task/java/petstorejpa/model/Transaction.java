package task.java.petstorejpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date executionDate;

    private int usersThatBoughtCount;

    private int usersThatDidntBuyCount;


    public Transaction(Date executionDate, int usersThatBoughtCount, int usersThatDidntBuyCount) {
        this.executionDate = executionDate;
        this.usersThatBoughtCount = usersThatBoughtCount;
        this.usersThatDidntBuyCount = usersThatDidntBuyCount;
    }

    public Transaction() {

    }
}