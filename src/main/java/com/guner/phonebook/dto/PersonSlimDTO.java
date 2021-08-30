package com.guner.phonebook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonSlimDTO {

    @ApiModelProperty(required = true,value = "Person ID")
    private Long id;

    @NotNull
    @ApiModelProperty(required = true,value = "Person Name")
    private String name;

    @NotNull
    @ApiModelProperty(required = true,value = "Person Surname")
    private String surname;
}
