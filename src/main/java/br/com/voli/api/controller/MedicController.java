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

import br.com.voli.api.medic.Medic;
import br.com.voli.api.medic.MedicListData;
import br.com.voli.api.medic.MedicRegisterData;
import br.com.voli.api.medic.MedicRepository;
import br.com.voli.api.medic.MedicUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    public void register(@RequestBody @Valid MedicRegisterData json) {
        repository.save(new Medic(json));
    }

    @GetMapping
    public Page<MedicListData> getMedicList(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(MedicListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid MedicUpdateData json) {
        repository.findById(json.id()).ifPresent(medic -> medic.update(json));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        repository.findById(id).ifPresent(medic -> medic.delete());
    }
}
