package br.com.voli.api.medic;

public record MedicListData(long id, String name, String crm, Speciality speciality, String email) {
    public MedicListData(Medic medic) {
        this(medic.getId(), medic.getName(), medic.getCrm(), medic.getSpeciality(), medic.getEmail());
    }
}
