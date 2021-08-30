package com.guner.phonebook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {

    @ApiModelProperty(required = true,value = "Person ID")
    private Long id;

    @NotNull
    @ApiModelProperty(required = true,value = "Person Name")
    private String name;

    @NotNull
    @ApiModelProperty(required = true,value = "Person Surname")
    private String surname;

    @NotNull
    @ApiModelProperty(required = true,value = "Person Phone Number")
    private String phoneNumber;

    @ApiModelProperty(value = "Person Notes")
    private String notes;

    @ApiModelProperty(value = "Person Status")
    private Boolean status;

}
