package org.validation.example.dto;

import lombok.Data;
import org.validation.example.annotation.CustomValidationAnno;
import org.validation.example.annotation.EndDate;
import org.validation.example.annotation.MustBeValid;
import org.validation.example.annotation.StartDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@MustBeValid
public class Dto {

    @NotNull
    @Positive
    private Integer age;
    @NotBlank
    @Pattern(regexp = "\\w+")
    private String name;
    @CustomValidationAnno
    private String toTest;
    @StartDate
    private LocalDate start;
    @EndDate
    private LocalDate end;

}
