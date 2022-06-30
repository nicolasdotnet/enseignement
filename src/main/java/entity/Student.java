package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("S")
public class Student extends Person{

    @Column(name = "birthDate" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name="trainer_id", nullable=false)
    private Trainer trainer;

    @ManyToMany
    private List<Subject> subjects;

    public Student() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
