package hiago.com.passin.domain.checkin.exceptions;

public class CheckInAlreadyExistsExeption extends RuntimeException {
    public CheckInAlreadyExistsExeption(String message){
        super(message);
    }
}
