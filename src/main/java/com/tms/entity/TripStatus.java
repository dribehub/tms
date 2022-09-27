package com.tms.entity;

import com.tms.enums.TripStatusEnum;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Entity @Table(name = "trip_status")
public class TripStatus {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public void setName(TripStatusEnum status) {
        this.name = status.name();
    }
}
