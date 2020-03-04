package br.com.control.handlers.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompanyDto {
    private Integer id;

    @NotNull
    private String name;
}
