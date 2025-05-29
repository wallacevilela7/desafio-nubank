package tech.wvs.desafionubank.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record CustomerDto(
        String name,
        String email,
        String cpf,
        @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        Date birthDate) {
}
