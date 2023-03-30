package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.Service.FlightService;
import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/provisioning")
    public ResponseEntity provisioning(){
        flightService.provisioning();
        return ResponseEntity.ok("50 flights created");
    }
    @GetMapping("/get-flights")
    public ResponseEntity getAllFlight(){
        return ResponseEntity.ok(flightService.getAllFlight());
    }
    @PostMapping("/provisioning2")
    public ResponseEntity provisioning2(){
        flightService.provisioning2();
        return ResponseEntity.ok("100 flights created");
    }

    @GetMapping("/get-all-fromAirport")
    public Page<Flight> getAllFromAirport(@RequestParam(required = false) Optional<Integer> page,
                                            @RequestParam(required = false) Optional<Integer> size,
                                          @RequestParam String fromAirport){
        Pageable pageable = PageRequest.of(page.get(),size.get());

        Page<Flight> flightPage = flightRepository.findAll(pageable);
        flightPage.getSort();
        return flightPage;
    }
    @GetMapping("get-all-by-ontime")
    public ResponseEntity getAllByOntime(){
        return ResponseEntity.ok(flightService.getAllByStatusOntime());
    }
    @GetMapping("get-all-by-status")
    public ResponseEntity getAllByStatus(@RequestParam FlightStatus p1,@RequestParam FlightStatus p2){
        return ResponseEntity.ok(flightService.getAllByStatus(p1,p2));
    }








    }

