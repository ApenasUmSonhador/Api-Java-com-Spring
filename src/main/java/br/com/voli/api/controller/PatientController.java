package br.com.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.voli.api.patient.Patient;
import br.com.voli.api.patient.PatientListData;
import br.com.voli.api.patient.PatientRegisterData;
import br.com.voli.api.patient.PatientRepository;
import br.com.voli.api.patient.PatientUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid PatientRegisterData json) {
        repository.save(new Patient(json));
    }

    @GetMapping
    public Page<PatientListData> getPatientList(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(PatientListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData json) {
        repository.findById(json.id()).ifPresent(patient -> patient.update(json));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        repository.findById(id).ifPresent(patient -> patient.delete());
    }
}
