package com.adidas.backend.appointment;

import com.adidas.backend.database.InMemoryDatabase;
import com.adidas.backend.scheduling.ScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/adidas")
public class AppointmentController {

    private final InMemoryDatabase inMemoryDatabase;
    private final ScheduledTasks scheduledTasks;

    @Autowired
    public AppointmentController(InMemoryDatabase inMemoryDatabase, ScheduledTasks scheduledTasks) {
        this.inMemoryDatabase = inMemoryDatabase;
        this.scheduledTasks = scheduledTasks;
    }

    @GetMapping(value = "/appointment")
    public Collection<Appointment> getAppointments() {
        return inMemoryDatabase.getAllAppointments();
    }

    @PostMapping(value = "/appointment")
    public Long saveAppointment(@RequestBody Appointment appointment) {
        inMemoryDatabase.decreaseStock(appointment.getStoreId(), appointment.getProductId());
        scheduledTasks.registerAppointment(appointment);
        return inMemoryDatabase.saveAppointment(appointment);
    }

    @DeleteMapping(value = "/appointment/{appointmentId}")
    public void cancelAppointment(@PathVariable Long appointmentId) {
        inMemoryDatabase.increaseStock(appointmentId);
        inMemoryDatabase.cancelAppointment(appointmentId);
    }

}
