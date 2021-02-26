package Exceptions;

public class AirCompanyNotFound extends Exception{
    private Long id;
    public AirCompanyNotFound(Long id) {
        super(String.format("There is no airCompany with id : '%s'", id));
    }
}

