package com.tms.enums;

import com.tms.entity.TripStatus;

import java.util.Arrays;
import java.util.Optional;

public enum TripStatusEnum {

    CREATED(1),
    WAITING_FOR_APPROVAL(2),
    APPROVED(3);

    public final TripStatus tripStatus;
    public final Integer id;

    TripStatusEnum(Integer id) {
        this.tripStatus = new TripStatus(id, name());
        this.id = id;
    }

    public static Optional<TripStatus> getTripStatusByName(String name) {
        return Arrays.stream(TripStatusEnum.values())
                .filter(re -> re.name().equals(name.toUpperCase()))
                .map(re -> re.tripStatus)
                .findFirst();
    }

    public static String[] names() {
        return Arrays.stream(TripStatusEnum.values())
                .map(TripStatusEnum::name).toArray(String[]::new);
    }
}
