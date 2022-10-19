package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity (name = "recipient")
@Getter
@Setter
public class RecipientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Pattern(regexp = "[A-Za-zÄÖÜäöüß]+\\s[0-9A-Za-zÄÖÜäöüß/]+")
    private String street;
    @Pattern(regexp = "^A-\\d{4}$")
    private String postalCode;
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    private String city;
    private String country;

    /**
     * Constructor-like functionality to build an Object
     */
    public RecipientModel name(String name) {
        this.name = name;
        return this;
    }

    public RecipientModel street(String street) {
        this.street = street;
        return this;
    }

    public RecipientModel postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public RecipientModel city(String city) {
        this.city = city;
        return this;
    }

    public RecipientModel country(String country) {
        this.country = country;
        return this;
    }
}
