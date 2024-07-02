package br.com.voli.api.commom;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
                @JsonProperty("logradouro") @NotBlank String street,
                @JsonProperty("bairro") @NotBlank String neighborhood,
                @NotBlank @Pattern(regexp = "\\d{8}") String cep,
                @JsonProperty("cidade") @NotBlank String city,
                @JsonProperty("uf") @NotBlank String state,
                @JsonProperty("numero") String number,
                @JsonProperty("complemento") String complement) {

}
