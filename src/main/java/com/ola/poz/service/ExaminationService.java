package com.ola.poz.service;

import com.ola.poz.exception.BindingResultException;
import com.ola.poz.exception.NotFoundException;
import com.ola.poz.model.Examination;
import com.ola.poz.repository.ExaminationRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;
    
    public Examination create(@Valid Examination examination, BindingResult bindingResult) {
        checkIfExaminationWithNameAlreadyExist(examination, null, bindingResult);
        return examinationRepository.save(examination);
    }

    public Examination getById(Long id) {
        Optional<Examination> examination = examinationRepository.findById(id);
        if(!examination.isPresent()){
            throw new NotFoundException(String.format("Examination with id %s does not exist", id));
        }
        return examination.get();
    }

    public Examination update(@Valid Examination update, Long id, BindingResult bindingResult) {
        Examination existingExamination = getById(id);
        checkIfExaminationWithNameAlreadyExist(update, existingExamination.getName(), bindingResult);

        existingExamination.setName(update.getName());
        existingExamination.setPrice(update.getPrice());

        return examinationRepository.save(existingExamination);
    }

    public void delete(Long id) {
        if(!examinationRepository.existsById(id)){
            throw new NotFoundException(String.format("Examination with id %s does not exist", id));
        }
        examinationRepository.deleteById(id);
    }

    private void checkIfExaminationWithNameAlreadyExist(Examination examination, String currentName, BindingResult bindingResult) {
        if (!examination.getName().equalsIgnoreCase(currentName)
                && examinationRepository.existsByNameIgnoreCase(examination.getName())) {
            bindingResult.addError(new FieldError("examination", "name", String.format("Examination with name %s already exists", examination.getName())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
