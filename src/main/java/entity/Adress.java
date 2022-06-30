package entity;

import javax.persistence.*;

@Entity
@Table(name="adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "complement", nullable = false)
    private String complement;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;
}
