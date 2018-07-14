package com.ola.poz.controller;

import com.ola.poz.model.Examination;
import com.ola.poz.repository.ExaminationRepository;
import com.ola.poz.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/examinations")
public class ExaminationController {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private ExaminationService examinationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Examination create(@RequestBody @Valid Examination examination, BindingResult bindingResult) {
        return examinationService.create(examination, bindingResult);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Examination> read(@RequestParam (defaultValue = "") String name) {
        return examinationRepository.findByNameContainingIgnoreCase(name);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Examination> read(){
//        return examinationRepository.findAll();
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Examination get(@PathVariable Long id) {
        return examinationService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Examination update(@RequestBody @Valid Examination examination, @PathVariable Long id, BindingResult bindingResult) {
        return examinationService.update(examination, id, bindingResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        examinationService.delete(id);
    }
}
