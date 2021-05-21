package com.testwork.rest.testwork.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightStatus;
    private Long airCompanyId;
    private Long airPlaneId;
    private String departureCountry;
    private String destinationCountry;
    private Long distance;
    private String estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;
}
