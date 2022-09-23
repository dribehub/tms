package com.tms.controller;

import com.tms.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/trips")
@RestController
public class TripController {

    private final TripService service;
}
