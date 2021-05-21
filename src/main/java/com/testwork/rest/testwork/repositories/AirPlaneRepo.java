package com.testwork.rest.testwork.repositories;

import com.testwork.rest.testwork.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface AirPlaneRepo extends JpaRepository<Airplane, Long> {
}
