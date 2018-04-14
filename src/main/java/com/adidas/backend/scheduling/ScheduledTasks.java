package com.adidas.backend.scheduling;

import com.adidas.backend.appointment.Appointment;
import com.adidas.backend.database.InMemoryDatabase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Value("${server.port}")
    private int port;

    private OkHttpClient client;
    private List<Appointment> appointments;

    @Autowired
    public ScheduledTasks(InMemoryDatabase inMemoryDatabase) {
        client = new OkHttpClient();
        appointments = new ArrayList<>(inMemoryDatabase.getAllAppointments());
    }

    @Scheduled(fixedRate = 5000)
    public void checkCloseToDueAppointments() throws IOException {
/*        if (appointments.size() > 0) {
            Appointment appointment = getRandomAppointment();
            String response = sendNotification(appointment);
            log.info("Server replied: {}", response);
        }*/
    }

    public void registerAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    private Appointment getRandomAppointment() {
        int randomPosition = ThreadLocalRandom.current().nextInt(0, appointments.size());
        return appointments.get(randomPosition);
    }

    private String sendNotification(Appointment appointment) throws IOException {
        RequestBody body = RequestBody.create(JSON, toJSON(appointment));
        Request request = buildRequest(body);
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private Request buildRequest(RequestBody body) {
        return new Request.Builder()
                .url("")
                .post(body)
                .build();
    }

    private String toJSON(Appointment appointment) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(appointment);
    }

}