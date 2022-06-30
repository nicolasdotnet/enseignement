package entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type" , nullable = false)
    private String type;

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
    
    private Adress adress;
}
