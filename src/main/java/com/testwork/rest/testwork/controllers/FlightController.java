package com.testwork.rest.testwork.controllers;

import com.testwork.rest.testwork.entities.Flight;
import com.testwork.rest.testwork.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> getAllCompanies() {
        return flightService.getAll();
    }

    @PostMapping("/create")
    public Flight createAirCompany(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @DeleteMapping("/remove/{id}")
    public Flight deleteId(@PathVariable Long id) {
        return flightService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Flight updateId(@PathVariable Long id,
                               @RequestBody Flight flight) {

        return flightService.update(id, flight);
    }

    @GetMapping("/{id}")
    public Flight getAirCompanyById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @GetMapping("/get/{status}/{airCompanyId}")
    public List<Flight> getAllByStatus(@PathVariable String status, @PathVariable Long airCompanyId) {
        return flightService.getAllByStatusAndAirCompany(status, airCompanyId);
    }

    @PutMapping("/changeStatus/{flightId}/{status}")
    public Flight changeStatus(@PathVariable Long flightId, @PathVariable String status) {
        Flight flight = flightService.getById(flightId);
        flight.setFlightStatus(status);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        
        final String DELAYED = "DELAYED";
        final String ACTIVE = "ACTIVE";
        final String COMPLETED = "COMPLETED";

        switch (status) {
            case DELAYED:
                flight.setDelayStartedAt(strDate);
                break;
            case ACTIVE:
                flight.setCreatedAt(strDate);
                break;
            case COMPLETED:
                flight.setEndedAt(strDate);
                break;
        }

        return flightService.save(flight);
    }
}
