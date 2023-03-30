package co.develhope.customqueries1.entities;

import org.springframework.data.domain.Sort;

import java.util.Random;

public enum FlightStatus {
    ONTIME, DELAYED, CANCELLED;

    private static final Random PRNG = new Random();

    public static FlightStatus random() {
        FlightStatus[] flightStatus = values();
        return flightStatus[PRNG.nextInt(flightStatus.length)];
    }
}