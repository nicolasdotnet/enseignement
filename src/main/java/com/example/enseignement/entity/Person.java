package com.example.enseignement.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "civility" , nullable = false)
    private String civility;

    @Column(name = "lastName" , nullable = false)
    private String lastName;

    @Column(name = "firstName" , nullable = false)
    private String firstName;

    @Column(name = "email" , nullable = false)
    @Email
    @Size(max = 255)
    private String email;

    @OneToOne
    @JoinColumn(name="adress_id", nullable=false)
    private Adress adress;

    public Person() {
    }

    public Person(String civility, String lastName, String firstName, String email, Adress adress) {
        this.civility = civility;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
