package com.testwork.rest.testwork.services;

import com.testwork.rest.testwork.entities.Airplane;
import com.testwork.rest.testwork.entities.Flight;
import com.testwork.rest.testwork.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;

    public List<Flight> getAll() {
        return flightRepo.findAll();
    }

    public Flight create(Flight flight) {
        flightRepo.save(flight);
        return flight;
    }

    public Flight deleteById(Long id) {
        Flight temp = flightRepo.findById(id).get();
        flightRepo.deleteById(id);
        return temp;
    }

    public Flight update(Long id, Flight flight) {
        Flight current = flightRepo.findById(id).get();

        flight.setId(id);
        flightRepo.save(flight);

        return current;
    }

    public Flight getById(Long id) {
        return flightRepo.getById(id);
    }

    public Flight save(Flight flight) {
        return flightRepo.save(flight);
    }

    public List<Flight> getAllByStatusAndAirCompany(String status, Long id) {
        List<Flight> flights = flightRepo.findAll();
        return  flights.stream().filter(v -> v.getFlightStatus().equals(status))
                                .filter(v -> v.getAirCompanyId().equals(id)).collect(Collectors.toList());
    }
}
