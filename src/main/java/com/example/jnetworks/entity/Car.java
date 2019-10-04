package com.example.jnetworks.entity;

import lombok.*;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    long id;

    @Pattern(regexp="[A-Z0-9\\- ]{4,16}")
    String carNumber;

    Timestamp timestamp;
}
