package com.example.demo.services;

import com.example.demo.models.Appointment;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.services.Interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImp implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> getAllAppointments (){ return appointmentRepository.findAll();}
    @Override

    public void addAppointment(Appointment newAppointment) {
        appointmentRepository.save(newAppointment);

    }
    @Override
    public void updateAppointment(Appointment updateAppointment) {
        appointmentRepository.save(updateAppointment);

    }
    @Override
    public void deleteAppointment(Integer id){
        appointmentRepository.deleteById(id);
    }

}

