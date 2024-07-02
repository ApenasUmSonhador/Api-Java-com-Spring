package br.com.voli.api.patient;

import br.com.voli.api.commom.AddressData;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(@NotNull long id, String name, String phone,
        AddressData address) {

}
