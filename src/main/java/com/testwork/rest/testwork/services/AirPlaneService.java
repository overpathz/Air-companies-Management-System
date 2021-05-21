package com.testwork.rest.testwork.services;

import com.testwork.rest.testwork.entities.Airplane;
import com.testwork.rest.testwork.repositories.AirCompanyRepo;
import com.testwork.rest.testwork.repositories.AirPlaneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPlaneService {
    @Autowired
    AirPlaneRepo airPlaneRepo;

    public List<Airplane> getAll() {
        return airPlaneRepo.findAll();
    }

    public Airplane create(Airplane airplane) {
        airPlaneRepo.save(airplane);
        return airplane;
    }

    public Airplane deleteById(Long id) {
        Airplane temp = airPlaneRepo.findById(id).get();
        airPlaneRepo.deleteById(id);
        return temp;
    }

    public Airplane update(Long id, Airplane airplane) {
        Airplane current = airPlaneRepo.findById(id).get();

        airplane.setId(id);
        airPlaneRepo.save(airplane);

        return current;
    }

    public Airplane getById(Long id) {
        return airPlaneRepo.getById(id);
    }

    public Airplane save(Airplane airplane) {
        return airPlaneRepo.save(airplane);
    }
}
