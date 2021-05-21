package com.testwork.rest.testwork.controllers;

import com.testwork.rest.testwork.entities.AirCompany;
import com.testwork.rest.testwork.services.AirCompanyService;
import com.testwork.rest.testwork.services.AirPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airCompany")
public class AirCompanyController {
    @Autowired
    private AirCompanyService airCompanyService;

    @GetMapping()
    public List<AirCompany> getAllCompanies() {
        return airCompanyService.getAll();
    }

    @PostMapping("/create")
    public AirCompany createAirCompany(@RequestBody AirCompany airCompany) {
        return airCompanyService.create(airCompany);
    }

    @DeleteMapping("/remove/{id}")
    public AirCompany deleteId(@PathVariable Long id) {
        return airCompanyService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public AirCompany updateId(@PathVariable Long id,
                               @RequestBody AirCompany airCompany) {

        return airCompanyService.update(id, airCompany);
    }

    @GetMapping("/{id}")
    public AirCompany getAirCompanyById(@PathVariable Long id) {
        return airCompanyService.getAirCompanyId(id);
    }
}
