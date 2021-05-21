package com.testwork.rest.testwork.controllers;

import com.testwork.rest.testwork.entities.AirCompany;
import com.testwork.rest.testwork.entities.Airplane;
import com.testwork.rest.testwork.services.AirPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plane")
public class PlaneController {
    @Autowired
    private AirPlaneService airPlaneService;

    @GetMapping()
    public List<Airplane> getAll() {
        return airPlaneService.getAll();
    }

    @PutMapping("/reasign/{planeId}/{companyID}")
    public Airplane reasignAirplane(@PathVariable Long planeId,
                                    @PathVariable Long companyID) {

        Airplane airplane = airPlaneService.getById(planeId);
        airplane.setAirCompanyId(companyID);
        return airPlaneService.save(airplane);
    }

    @DeleteMapping("/remove/{id}")
    public Airplane deleteId(@PathVariable Long id) {
        return airPlaneService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Airplane updateId(@PathVariable Long id,
                               @RequestBody Airplane airplane) {

        return airPlaneService.update(id, airplane);
    }

    @GetMapping("/{id}")
    public Airplane getAirCompanyById(@PathVariable Long id) {
        return airPlaneService.getById(id);
    }

    @PostMapping("/add")
    public Airplane add(@RequestBody Airplane airplane) {
        return airPlaneService.create(airplane);
    }

}
