package com.tms.enums;

import com.tms.entity.TripReason;

import java.util.Arrays;
import java.util.Optional;

public enum TripReasonEnum {

    MEETING(1),
    TRAINING(2),
    PROJECT(3),
    WORKSHOP(4),
    EVENT(5),
    OTHER(6);

    public final TripReason tripReason;
    public final Integer id;

    TripReasonEnum(Integer id) {
        this.tripReason = new TripReason(id, name());
        this.id = id;
    }

    public static Optional<TripReason> getTripReasonByName(String name) {
        return Arrays.stream(TripReasonEnum.values())
                .filter(tre -> tre.name().equals(name.toUpperCase()))
                .map(tre -> tre.tripReason)
                .findFirst();
    }

    public static String[] names() {
        return Arrays.stream(TripReasonEnum.values())
                .map(TripReasonEnum::name).toArray(String[]::new);
    }
}
