package com.tms.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Entity @Table(name = "trip")
public class Trip {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne @JoinColumn(name = "reason_id", referencedColumnName = "id")
    private TripReason reason;

    private String description;

    @ManyToOne @JoinColumn(name = "from_country")
    private Country from;

    @ManyToOne @JoinColumn(name = "to_country")
    private Country to;

    private Date departure;

    private Date arrival;

    @ManyToOne @JoinColumn(name = "created_by")
    private User createdBy;

    private Timestamp createdAt;

    @ManyToOne @JoinColumn(name = "status_id")
    private TripStatus status;
}
