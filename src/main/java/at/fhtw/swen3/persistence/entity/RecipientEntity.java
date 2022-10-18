package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity (name = "recipient")
@Getter
@Setter
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Pattern(regexp = "[a-zA-Zäöüß]+\s[0-9a-zA-Z/]+")
    private String street;
    @Pattern(regexp = "[A-Z]-[0-9]{4}")
    private String postalCode;
    @Pattern(regexp = "[A-ZÄÖÜ][a-zäöü]+\\.?\s?([A-ZÄÖÜ][a-zäöüß]+)*")
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
