package br.com.voli.api.medic;

import br.com.voli.api.commom.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medics")
@Entity(name = "medic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    public Medic(MedicRegisterData dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.crm = dados.crm();
        this.phone = dados.phone();
        this.speciality = dados.speciality();
        this.active = true;
        this.address = new Address(dados.addressData());
    }

    public Object update(@Valid MedicUpdateData json) {
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
