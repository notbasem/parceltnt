package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;

    /**
     * Constructor-like functionality to build an Object
     */
    public Recipient name(String name) {
        this.name = name;
        return this;
    }

    public Recipient street(String street) {
        this.street = street;
        return this;
    }

    public Recipient postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Recipient city(String city) {
        this.city = city;
        return this;
    }

    public Recipient country(String country) {
        this.country = country;
        return this;
    }
}
