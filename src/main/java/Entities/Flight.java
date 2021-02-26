package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    // ID SHOULD BE UNUSED. AND ONLY GETTER FOR HIM
    private Long ID;
    private Long airCompanyId;
    private Long airplaneId;
    private Long distance;
    private Double estimatedFlightTime;
    private Double endedAt;
    private Double delayStartedAt;
    private String createdAt;
    private String flightStatus;
    private String departureCountry;
    private String destinationCountry;

    protected Flight(){}

    public Flight(Long airCompanyId, Long airplaneId, Long distance, Double estimatedFlightTime,
                  Double endedAt, Double delayStartedAt, String createdAt, String flightStatus, String departureCountry, String destinationCountry) {
        this.airCompanyId = airCompanyId;
        this.airplaneId = airplaneId;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.endedAt = endedAt;
        this.delayStartedAt = delayStartedAt;
        this.createdAt = createdAt;
        this.flightStatus = flightStatus;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
    }

    public Long getID() {
        return ID;
    }

    public Long getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(Long airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Double getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(Double estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public Double getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Double endedAt) {
        this.endedAt = endedAt;
    }

    public Double getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(Double delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ID=" + ID +
                ", airCompanyId=" + airCompanyId +
                ", airplaneId=" + airplaneId +
                ", distance=" + distance +
                ", estimatedFlightTime=" + estimatedFlightTime +
                ", endedAt=" + endedAt +
                ", delayStartedAt=" + delayStartedAt +
                ", createdAt=" + createdAt +
                ", flightStatus='" + flightStatus + '\'' +
                ", departureCountry='" + departureCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                '}';
    }
}
