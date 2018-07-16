package com.ola.poz.controller;

import com.ola.poz.model.Appointment;
import com.ola.poz.repository.AppointmentRepository;
import com.ola.poz.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody @Valid Appointment appointment){
        return appointmentService.create(appointment);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> search(@RequestParam(required = false) Long patientId) {
        if (null != patientId) {
            return appointmentRepository.findByPatient_Id(patientId);
        }
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment get(@PathVariable Long id){
        return appointmentService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@RequestBody @Valid Appointment appointment, @PathVariable Long id){
        return appointmentService.update(appointment, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        appointmentService.delete(id);
    }

}
