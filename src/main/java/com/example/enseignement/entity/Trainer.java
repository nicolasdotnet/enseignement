package com.example.enseignement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
@DiscriminatorValue("t")
public class Trainer extends Person {

    @Column(name = "hireDate")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "experience")
    private int experience;

    @Column(name = "interne")
    private int interne;

    @OneToMany()
    @JoinColumn(name = "trainer_id")
    private List<Student> students;

    public Trainer() {
    }

    public Trainer(String civility, String lastName, String firstName, String email, Adress adress, Date hireDate, int experience, int interne) {
        super(civility, lastName, firstName, email, adress);
        this.hireDate = hireDate;
        this.experience = experience;
        this.interne = interne;
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
