package entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="student")
public class Student extends Person{

    @Column(name = "birthDate" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private Trainer trainer;
}
