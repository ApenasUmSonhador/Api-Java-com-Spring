package br.com.voli.api.medic;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.voli.api.commom.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MedicRegisterData(
                @NotBlank @JsonProperty("nome") String name,

                @NotBlank @Email @JsonProperty("email") String email,

                @NotBlank @Pattern(regexp = "\\d{4,6}") @JsonProperty("crm") String crm,

                @NotBlank @JsonProperty("telefone") String phone,

                @NotBlank @JsonProperty("especialidade") Speciality speciality,

                @Valid @JsonProperty("endereco") AddressData addressData) {
}
