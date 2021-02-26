package Dao;

import Entities.AirCompany;
import Entities.Airplane;
import Entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AirCompanyDaoImpl implements AirCompanyDao {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AirCompanyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AirCompany addAirCompany(AirCompany airCompany) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airCompany);
        LOGGER.info("AirCompany successful added! AirCompany details: " + airCompany);
        return airCompany;
    }

    @Override
    public void updateAirCompany(AirCompany airCompany) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(airCompany);
        LOGGER.info("AirCompany successful updated! AirCompany details: " + airCompany);
    }

    @Override
    public void removeAirCompany(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirCompany airCompany = session.load(AirCompany.class, id);

        if (airCompany != null) {
            session.delete(airCompany);
        }

        LOGGER.info("AirCompany successful deleted" + airCompany);
    }

    @Override
    public AirCompany getAirCompanyById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirCompany airCompany = session.load(AirCompany.class, id);
        LOGGER.info("AirCompany successful got" + airCompany);

        return airCompany;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AirCompany> listAirCompanies() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AirCompany> airCompaniesList = session.createQuery("from AirCompany").list();

        for (AirCompany air: airCompaniesList) {
            LOGGER.info("AirCompaniesList: " + air);
        }

        return airCompaniesList;
    }

    @Override
    public List<Flight> findAllAirCompanyFlightByStatus(String status) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Flight> sndFlightLs = session.createQuery("from Flight").list();
        List<Flight> modFlightLs = new ArrayList<>();

        for (Flight x: sndFlightLs) {
            if (x.getFlightStatus().equals(status)) {
                modFlightLs.add(x);
            }
        }

        return modFlightLs;
    }

    //This method have two controllers
    @Override
    public Airplane addNewAirplane(Airplane airplane) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airplane);
        LOGGER.info("Airplane successful added! Airplane details: " + airplane);
        return airplane;
    }

    @Override
    public List<Flight> findAllActiveStatusFlights() throws ParseException {
        Session session = this.sessionFactory.getCurrentSession();
        List<Flight> sndFlightLs = session.createQuery("from Flight").list();
        List<Flight> modFlightLs = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Date newDate = new Date();
        String strDate = dateFormat.format(newDate);
        Date currentDate = dateFormat.parse(strDate);

        for (Flight x : sndFlightLs) {
            Date tmp = dateFormat.parse(x.getCreatedAt());

            long milliseconds = currentDate.getTime() - tmp.getTime();
            int hours = (int) (milliseconds / (60 * 60 * 1000));

            if (x.getFlightStatus().equals("ACTIVE") && hours >= 24) {
                modFlightLs.add(x);
            }
        }

        return modFlightLs;
    }

    @Override
    public Flight addNewFlight(Flight flight) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(flight);
        flight.setFlightStatus("PENDING");
        LOGGER.info("Flight successful added! Flight details: " + flight);
        return flight;
    }

    //TODO: FINISH LATEST EXERCISE
    @Override
    public Flight changeFlightStatus(String status, Flight flight) {
        if (status.equals("DELAYED")) {

        } else if (status.equals("ACTIVE")) {

        } else if (status.equals("COMPLETED")) {

        }

        return null;
    }
}
