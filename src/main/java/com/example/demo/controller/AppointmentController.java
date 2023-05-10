package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Appointment;
import com.example.demo.services.Interfaces.AppointmentService;

import java.util.List;
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getAllAppointments")
    public List <Appointment> getAllAppointments(){return appointmentService.getAllAppointments();}

    @PostMapping("/createappointment")
    public ResponseEntity<Appointment> addAppointment (@RequestBody Appointment newAppointment) {
        appointmentService.addAppointment(newAppointment);
        return new ResponseEntity<Appointment>(newAppointment, HttpStatus.OK);
    }
    @PutMapping("/UpdateAppointment")
    public ResponseEntity<Appointment> updateAppointment (@RequestBody Appointment updateAppointment) {
        appointmentService.updateAppointment(updateAppointment);
        return new ResponseEntity<Appointment>(updateAppointment, HttpStatus.OK);
    }
    @DeleteMapping("/DeleteAppointment")
    public void deleteAppointment (@RequestParam Integer id) {
        appointmentService.deleteAppointment(id);

    }
}
