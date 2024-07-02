package br.com.voli.api.patient;

public record PatientListData(long id, String name, String email, String cpf) {
    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
