package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("S")
public class Trainer extends Person {

    @Column(name = "hireDate" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "experience" , nullable = false)
    private int experience;

    @Column(name = "interne" , nullable = false)
    private int interne;

    @OneToMany
    private List<Student> students;

    public Trainer() {
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getInterne() {
        return interne;
    }

    public void setInterne(int interne) {
        this.interne = interne;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
