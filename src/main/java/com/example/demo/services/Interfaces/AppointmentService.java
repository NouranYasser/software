package com.example.demo.services.Interfaces;
import com.example.demo.models.Appointment;
import java.util.List;
public  interface AppointmentService {
    void addAppointment(Appointment newAppointment);
    void updateAppointment(Appointment updateAppointment);
    void deleteAppointment(Integer id);
    List<Appointment> getAllAppointments();
}

