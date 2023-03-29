package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.Service.FlightService;
import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/provisioning")
    public ResponseEntity provisioning(){
        flightService.provisioning();
        return ResponseEntity.ok("50 flights created");
    }
    @GetMapping("/get-flights")
    public ResponseEntity getAllFlight(){
        return ResponseEntity.ok(flightService.getAllFlight());
    }





    }

