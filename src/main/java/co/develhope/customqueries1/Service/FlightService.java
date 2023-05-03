package co.develhope.customqueries1.Service;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public String generateString() {
        int leftLimit = 38;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    public void provisioning() {
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription(generateString());
            flight.setFromAirport(generateString());
            flight.setToAirport(generateString());
            flight.setStatus(FlightStatus.ONTIME);

            flightRepository.save(flight);
        }
    }

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    public void provisioning2() {
        for (int i = 0; i < 100; i++) {
            Flight flight2 = new Flight();
            flight2.setDescription(generateString());
            flight2.setFromAirport(generateString());
            flight2.setToAirport(generateString());
            flight2.setStatus(FlightStatus.random());
            flightRepository.save(flight2);
        }
    }
    public List<Flight> getAllByStatusOntime(){

        return flightRepository.getAllByStatus(FlightStatus.ONTIME);
    }

    public List<Flight> getAllByStatus(FlightStatus p1,FlightStatus p2){
        return  flightRepository.findAllByStatus( p1, p2);
    }


}
