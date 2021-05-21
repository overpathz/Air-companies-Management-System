package com.testwork.rest.testwork.services;

import com.testwork.rest.testwork.entities.AirCompany;
import com.testwork.rest.testwork.repositories.AirCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirCompanyService {
    @Autowired
    AirCompanyRepo airCompanyRepo;

    public List<AirCompany> getAll() {
        return airCompanyRepo.findAll();
    }

    public AirCompany create(AirCompany airCompany) {
        airCompanyRepo.save(airCompany);
        return airCompany;
    }

    public AirCompany deleteById(Long id) {
        AirCompany temp = airCompanyRepo.findById(id).get();
        airCompanyRepo.deleteById(id);
        return temp;
    }

    public AirCompany update(Long id, AirCompany airCompany) {
        AirCompany current = airCompanyRepo.findById(id).get();

        airCompany.setId(id);
        airCompanyRepo.save(airCompany);

        return current;
    }

    public AirCompany getAirCompanyId(Long id) {
        return airCompanyRepo.getById(id);
    }
}
