package com.adidas.backend.appointment;

import com.adidas.backend.database.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/adidas")
public class AppointmentController {

    private final InMemoryDatabase inMemoryDatabase;

    @Autowired
    public AppointmentController(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @GetMapping(value = "/appointment")
    public Collection<Appointment> getAppointments() {
        return inMemoryDatabase.getAllAppointments();
    }

    @PostMapping(value = "/appointment")
    public Long saveAppointment(@RequestBody Appointment appointment) {
        inMemoryDatabase.decreaseStock(appointment.getStoreId(), appointment.getProductId());
        return inMemoryDatabase.saveAppointment(appointment);
    }

    @DeleteMapping(value = "/appointment/{appointmentId}")
    public void cancelAppointment(@PathVariable Long appointmentId) {
        inMemoryDatabase.increaseStock(appointmentId);
        inMemoryDatabase.cancelAppointment(appointmentId);
    }

}
