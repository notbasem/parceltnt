package at.fhtw.swen3.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

//@Entity (name = "hop_arrival")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HopArrivalEntity {
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
    private ParcelEntity fk_parcel;
}
