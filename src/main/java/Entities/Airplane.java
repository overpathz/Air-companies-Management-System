package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    // ID SHOULD BE UNUSED. AND ONLY GETTER FOR HIM
    private Long ID;
    private Long id;
    private Long flightDistance;
    private Long airCompanyId;
    private Integer serialNumber;
    private Integer numberOfFlights;
    private Integer fuelCapacity;
    private String name;
    private String factory;
    private String type;

    protected Airplane() {}

    public Airplane(Long id, Long flightDistance, Integer serialNumber, Long airCompanyId,
                    Integer numberOfFlights, Integer fuelCapacity, String name, String factory, String type) {
        this.id = id;
        this.flightDistance = flightDistance;
        this.serialNumber = serialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlights = numberOfFlights;
        this.fuelCapacity = fuelCapacity;
        this.name = name;
        this.factory = factory;
        this.type = type;
    }

    public Long getID() {
        return ID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(Long flightDistance) {
        this.flightDistance = flightDistance;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(Long airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public Integer getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(Integer numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AirCompanies{" +
                "id=" + id +
                ", flightDistance=" + flightDistance +
                ", serialNumber=" + serialNumber +
                ", airCompanyId=" + airCompanyId +
                ", numberOfFlights=" + numberOfFlights +
                ", fuelCapacity=" + fuelCapacity +
                ", name='" + name + '\'' +
                ", factory='" + factory + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
