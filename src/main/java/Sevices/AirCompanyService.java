package Sevices;

import Entities.AirCompany;
import Entities.Airplane;
import Entities.Flight;

import java.util.List;

public interface AirCompanyService {
    public AirCompany addAirCompany(AirCompany airCompany);
    public void updateAirCompany(AirCompany airCompany);
    public void removeAirCompany(Long id);
    public AirCompany getAirCompanyById(Long id);
    public List<AirCompany> listAirCompanies();
    public Airplane moveAirPlaneBetweenCompanies(Airplane airplane, AirCompany airCompany);
    public List<Flight> findAllAirCompanyFlights(String status);
    public Airplane addNewAirplane(Airplane airplane);
}
