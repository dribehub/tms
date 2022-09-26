package com.tms.dto;

import com.tms.entity.Country;
import com.tms.entity.TripReason;
import com.tms.entity.TripStatus;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class TripDto {

    private Integer id;
    private TripReason reason;
    private String description;
    private Country from;
    private Country to;
    private Date departure;
    private Date arrival;
    private UserDto createdBy;
    private Timestamp createdAt;
    private TripStatus status;
}
