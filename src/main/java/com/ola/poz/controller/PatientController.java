package com.ola.poz.controller;

import com.ola.poz.model.Patient;
import com.ola.poz.repository.PatientRepository;
import com.ola.poz.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@RequestBody @Valid Patient patient, BindingResult bindingResult) {
        return patientService.create(patient, bindingResult);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Patient> read(){
//        return patientRepository.findAll();
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> read(@RequestParam (defaultValue = "") String surname){
        return patientRepository.findBySurnameContainingIgnoreCase(surname);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient get(@PathVariable Long id) {
        return patientService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@RequestBody @Valid Patient patient, @PathVariable Long id, BindingResult bindingResult) {
        return patientService.update(patient, id, bindingResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }
}
