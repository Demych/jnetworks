package com.example.jnetworks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @NotNull(message = "car number can't be null")
    @Pattern(regexp="[A-Z0-9\\- ]{4,16}", message = "invalid car number format")
    private String carNumber;

    private Timestamp timestamp;
}
