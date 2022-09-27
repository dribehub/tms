package com.tms.dto;

import com.tms.entity.Country;
import com.tms.entity.TripReason;
import com.tms.entity.TripStatus;
import com.tms.enums.TripReasonEnum;
import com.tms.enums.TripStatusEnum;
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
    private Timestamp createdAt; // TODO: consider removing this field
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
}
