package task.java.petstorejpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "buyers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private double budget;

    public User(@JsonProperty String firstName,
                @JsonProperty String lastName,
                @JsonProperty String email,
                @JsonProperty double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }

    public User() {

    }
}
