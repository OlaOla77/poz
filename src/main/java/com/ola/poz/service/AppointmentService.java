package com.ola.poz.service;

import com.ola.poz.exception.NotFoundException;
import com.ola.poz.model.Appointment;
import com.ola.poz.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment getById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (!appointment.isPresent()) {
            throw new NotFoundException(String.format("Appointment with id %s does not exist", id));
        }
        return appointment.get();
    }

    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment update(Appointment update, Long id) {
        Appointment existingAppointment = getById(id);

        existingAppointment.setPatient(update.getPatient());
        existingAppointment.setDescription(update.getDescription());
        existingAppointment.setAppointmentDate(update.getAppointmentDate());
        existingAppointment.setExaminations(update.getExaminations());

        return appointmentRepository.save(existingAppointment);
    }

    public void delete(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new NotFoundException(String.format("Appointment with id %s does not exist", id));
        }
        appointmentRepository.deleteById(id);
    }

}
