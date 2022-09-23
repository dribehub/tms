package com.tms.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class FlightDto {

    private Integer id;
    private TripDto trip;
}
