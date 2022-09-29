package com.tms.entity;

import com.tms.enums.TripReasonEnum;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Entity @Table(name = "trip_reason")
public class TripReason {

    @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public void setName(TripReasonEnum reason) {
        this.name = reason.name();
    }
}
