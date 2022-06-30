package entity;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;
}
