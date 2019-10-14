package com.example.jnetworks.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @NotNull(message = "car number can't be null")
    @Pattern(regexp = "[A-Z0-9\\- ]{4,16}", message = "invalid car number format")
    private String carNumber;

    private String timestamp;
}

