package co.develhope.customqueries1.repositories;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> getAllByStatus(FlightStatus status);

    @Query("select * from flight where status =:1 or status = :2")
    List<Flight>findAllByStatus(FlightStatus p1,FlightStatus p2);

    // Pageable pageable = PageRequest.of(0,10);
    //@Query("select * from flight order by from_airport ASC")
   // Page<Flight>findAllByFromAirport();
}
