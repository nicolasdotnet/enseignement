package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="trainer")
public class Trainer extends Person {

    @Column(name = "hireDate" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "experience" , nullable = false)
    private int experience;

    @Column(name = "interne" , nullable = false)
    private int interne;
}
