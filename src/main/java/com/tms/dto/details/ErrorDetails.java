package com.tms.dto.details;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter @AllArgsConstructor
public class ErrorDetails {

    private final Date timestamp;
    private final String message;
    private final String details;
}
