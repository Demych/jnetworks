package com.example.jnetworks.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    private Long id;

    @Pattern(regexp="[A-Z0-9\\- ]{4,16}")
    @Size()
    private String carNumber;

    private Timestamp timestamp;
}
