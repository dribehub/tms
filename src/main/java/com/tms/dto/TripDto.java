package com.tms.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class TripDto {

    private Integer id;
    private TripReasonDto reason;
    private String description;
    private CountryDto from;
    private CountryDto to;
    private Date departure;
    private Date arrival;
    private UserDto createdBy;
    private Timestamp createdAt;
    private TripStatusDto status;
}
