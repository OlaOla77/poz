package com.ola.poz.service;

import com.ola.poz.exception.BindingResultException;
import com.ola.poz.exception.NotFoundException;
import com.ola.poz.model.Patient;
import com.ola.poz.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient getById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (!patient.isPresent()) {
            throw new NotFoundException(String.format("Patient with id %s does not exist", id));
        }
        return patient.get();
    }

    public Patient create(Patient patient, BindingResult bindingResult) {
        checkIfPatientWithPeselAlreadyExists(patient, null, bindingResult);
        return patientRepository.save(patient);
    }

    public Patient update(Patient update, Long id, BindingResult bindingResult) {
        Patient existingPatient = getById(id);

        checkIfPatientWithPeselAlreadyExists(update, existingPatient.getPesel(), bindingResult);

        existingPatient.setName(update.getName());
        existingPatient.setSurname(update.getSurname());
        existingPatient.setPesel(update.getPesel());
        existingPatient.setContact(update.getContact());

        return patientRepository.save(existingPatient);
    }

    private void checkIfPatientWithPeselAlreadyExists(Patient patient, Long currentPesel, BindingResult bindingResult) {
        if (!patient.getPesel().equals(currentPesel) && patientRepository.existsByPesel(patient.getPesel())) {
            bindingResult.addError(new FieldError("patient", "pesel", String.format("Patient with pesel %s already exists!", patient.getPesel())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

    public void delete(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new NotFoundException(String.format("Patient with id %s does not exist!", id));
        }
        patientRepository.deleteById(id);
    }

}
