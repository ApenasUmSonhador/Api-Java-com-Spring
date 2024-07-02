package br.com.voli.api.medic;

import br.com.voli.api.commom.AddressData;
import jakarta.validation.constraints.NotNull;

public record MedicUpdateData(@NotNull long id, String name, String phone, AddressData address) {

}
