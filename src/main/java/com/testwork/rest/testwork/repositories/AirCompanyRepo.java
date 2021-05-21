package com.testwork.rest.testwork.repositories;

import com.testwork.rest.testwork.entities.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface AirCompanyRepo extends JpaRepository<AirCompany, Long> {
}
