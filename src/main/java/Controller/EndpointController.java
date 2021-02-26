package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.logging.Logger;

import Entities.AirCompany;
import Entities.Airplane;
import Entities.Flight;
import Sevices.AirCompanyService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EndpointController {
    AirCompanyService airCompanyService;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EndpointController.class);

    @GetMapping("/createAirCompany")
    public AirCompany createAirCompany(@Valid @RequestBody AirCompany airCompany) {
        return airCompanyService.addAirCompany(airCompany);
    }

    @GetMapping("/airCompanies")
    public List getAllAirCompanies() {
        return airCompanyService.listAirCompanies();
    }

    @GetMapping("/airCompany/{id}")
    public Object getAirCompanyById(@PathVariable(value = "id") Long id) {
        if (airCompanyService.getAirCompanyById(id) == null) {
            return "There is no company with " + id + " id";
        }
        return airCompanyService.getAirCompanyById(id);
    }

    @PutMapping("/airCompany/{id}")
    public AirCompany updateAirCompany(@PathVariable(value = "id") Long id,
                                       @Valid @RequestBody AirCompany airCompanyDetails) {
        AirCompany airCompany = airCompanyService.getAirCompanyById(id);
        airCompany.setCompanyType(airCompanyDetails.getType());
        airCompany.setName(airCompany.getName());
        airCompany.setFoundedAt(airCompanyDetails.getFoundedAt());

        return airCompany;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAirCompany(@PathVariable(value = "id") Long id) {
        airCompanyService.removeAirCompany(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/moveAirPlaneToCompany/{AirCompanyId}/{AirPlaneId}")
    public Airplane moveAirPlaneToCompany(@RequestBody Airplane airplane,
                                          @RequestBody AirCompany airCompany) {

        return airCompanyService.moveAirPlaneBetweenCompanies(airplane, airCompany);
    }

    @GetMapping("/flights/{status}")
    public List<Flight> getAllFlightsByStatus(@PathVariable(value = "status") String status) {
      return airCompanyService.findAllAirCompanyFlights(status);
    }


    @GetMapping("/createAirplane")
    public Airplane createNewAirplane(@Valid @RequestBody Airplane airplane) {
        return airCompanyService.addNewAirplane(airplane);
    }

    @GetMapping("/createAirplane/{hourDelay}")
    public Airplane sss(@Valid @RequestBody Airplane airplane, @PathVariable (value = "hourDelay") String hourDelay) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.H");
        Date date1 = new Date();
        String strDate = dateFormat.format(date1);


        while (!strDate.equals(hourDelay)) {
            strDate = dateFormat.format(date1);
            if (strDate.equals(hourDelay)) {
                return airCompanyService.addNewAirplane(airplane);
            }
        }
        return null;
    }

}
