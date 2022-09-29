package com.tms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tms.entity.Country;
import com.tms.entity.TripReason;
import com.tms.entity.TripStatus;
import com.tms.enums.TripReasonEnum;
import com.tms.enums.TripStatusEnum;
import com.tms.exception.validation.trip.InvalidIntervalException;
import com.tms.exception.validation.trip.InvalidItineraryException;
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

    public boolean isOf(TripReasonEnum reason) {
        return reason.name().equals(this.reason.getName());
    }

    public boolean isOf(TripStatusEnum status) {
        return status.name().equals(this.status.getName());
    }

    public boolean isApproved() {
        return TripStatusEnum.APPROVED.name().equals(this.status.getName());
    }

    public void setReason(TripReason reason) {
        this.reason = reason;
    }

    public void setFrom(Country from) {
        if (to != null && to.equals(from))
            throw new InvalidItineraryException();
        this.from = from;
    }

    public void setTo(Country to) {
        if (from != null && from.equals(to))
            throw new InvalidItineraryException();
        this.to = to;
    }

    public void setDeparture(Date departure) {
        if (arrival != null && departure != null && !arrival.after(departure))
            throw new InvalidIntervalException();
        this.departure = departure;
    }

    public void setArrival(Date arrival) {
        if (departure != null && arrival != null && !arrival.after(departure))
            throw new InvalidIntervalException();
        this.arrival = arrival;
    }
}
