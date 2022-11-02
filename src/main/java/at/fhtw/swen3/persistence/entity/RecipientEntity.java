package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

//@Entity (name = "recipient")
@Getter
@Setter
public class RecipientEntity {
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    private String name;
    @Pattern(regexp = "[A-Za-zÄÖÜäöüß]+\\s[0-9A-Za-zÄÖÜäöüß/]+")
    private String street;
    @Pattern(regexp = "^[AD]-\\d{4}$")
    private String postalCode;
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
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
