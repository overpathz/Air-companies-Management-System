package Sevices;

import Dao.AirCompanyDao;
import Entities.AirCompany;
import Entities.Airplane;
import Entities.Flight;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
//TODO MAKE ENDPOINT TO LATEST METHOD
@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private AirCompanyDao airCompanyDao;

    public void setAirCompanyDao(AirCompanyDao airCompanyDao) {
        this.airCompanyDao = airCompanyDao;
    }

    @Override
    @Transactional
    public AirCompany addAirCompany(AirCompany airCompany) {
        return this.airCompanyDao.addAirCompany(airCompany);
    }

    @Override
    @Transactional
    public void updateAirCompany(AirCompany airCompany) {
        this.airCompanyDao.updateAirCompany(airCompany);
    }

    @Override
    @Transactional
    public void removeAirCompany(Long id) {
        this.airCompanyDao.removeAirCompany(id);
    }

    @Override
    @Transactional
    public AirCompany getAirCompanyById(Long id) {
        return this.airCompanyDao.getAirCompanyById(id);
    }

    @Override
    @Transactional
    public List<AirCompany> listAirCompanies() {
        return this.airCompanyDao.listAirCompanies();
    }

    @Override
    @Transactional
    public Airplane moveAirPlaneBetweenCompanies(Airplane airplane, AirCompany airCompany) {
        airplane.setAirCompanyId(airCompany.getID());
        return airplane;
    }

    @Override
    @Transactional
    public List<Flight> findAllAirCompanyFlights(String status) {
        return airCompanyDao.findAllAirCompanyFlightByStatus(status);
    }

    @Override
    @Transactional
    public Airplane addNewAirplane(Airplane airplane) {
        return airCompanyDao.addNewAirplane(airplane);
    }
}
