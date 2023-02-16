package task.java.petstorejpa.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import task.java.petstorejpa.enumerations.Type;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;


@Data
@Entity
@Table(name = "Pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Transient
    @ManyToOne//(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private User owner;
    private Long ownerI;

    private String name;

    private Type type;

    private String description;

    private Date dateOfBirth;

    private float price;

    private int rating;

    public Pet(@JsonProperty String name, @JsonProperty Type type, @JsonProperty String description, @JsonProperty String dateOfBirth, @JsonProperty int rating) {
        this.owner = null;
        this.ownerI=null;
        this.name = name;
        this.type = type;
        this.description = description;
        this.dateOfBirth = new Date(dateOfBirth);
        this.price = type==Type.CAT ? (new Date()).getYear() - this.dateOfBirth.getYear() : (new Date()).getYear() - this.dateOfBirth.getYear() + rating;
        this.rating = type==Type.CAT ? -1 : rating;
    }

    public Pet() {

    }

    public String getDateOfBirth() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String stringDateOfBirth = dateFormat.format(this.dateOfBirth.getTime());
        return stringDateOfBirth;
    }
}
