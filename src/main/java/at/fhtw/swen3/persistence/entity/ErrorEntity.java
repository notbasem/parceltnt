package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

//@Entity(name = "error")
@Getter
@Setter
public class ErrorEntity {
    private String errorMessage;
}
