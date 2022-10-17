package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity (name = "recipient")
@Getter
@Setter
public class RecipientEntity {
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
    public RecipientEntity name(String name) {
        this.name = name;
        return this;
    }

    public RecipientEntity street(String street) {
        this.street = street;
        return this;
    }

    public RecipientEntity postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public RecipientEntity city(String city) {
        this.city = city;
        return this;
    }

    public RecipientEntity country(String country) {
        this.country = country;
        return this;
    }
}
