package com.adidas.backend.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private Long storeId;
    private Long productId;
    private DayOfWeek dayOfWeek;
    private Integer hourOfDay;

}
