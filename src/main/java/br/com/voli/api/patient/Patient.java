package br.com.voli.api.patient;

import br.com.voli.api.commom.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name = "patients")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    @Embedded
    private Address address;
    private boolean active;

    public Patient(PatientRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.active = true;
        this.address = new Address(data.addressData());
    }

    public Object update(@Valid PatientUpdateData json) {
        if (json.name() != null) {
            this.name = json.name();
        }
        if (json.phone() != null) {
            this.phone = json.phone();
        }
        if (json.address() != null) {
            this.address.update(json.address());
        }
        return this;
    }

    public Object delete() {
        this.active = false;
        return this;
    }
}
