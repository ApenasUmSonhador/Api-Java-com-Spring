package br.com.voli.api.patient;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.voli.api.commom.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientRegisterData(

        @NotBlank @JsonProperty("nome") String name,
        @NotBlank @Email @JsonProperty("email") String email,
        @NotBlank @JsonProperty("telefone") String phone,
        @NotBlank String cpf,

        @JsonProperty("endereco") @Valid AddressData addressData) {

}
