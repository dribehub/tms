package com.tms.controller;

import com.tms.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/flights")
@RestController
public class FlightController {

    private final FlightService service;
}
