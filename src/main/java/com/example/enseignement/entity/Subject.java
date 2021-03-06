package com.example.enseignement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subject")
@NamedQuery(name = "Subject.findAllByDifficulty", query = "from Subject m where m.difficulty = :dif")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(
            name = "skill",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Student> Students;

    public Subject() {
    }

    public Subject(String name, int duration, Difficulty difficulty) {
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public void setStudents(List<Student> students) {
        Students = students;
    }
}
