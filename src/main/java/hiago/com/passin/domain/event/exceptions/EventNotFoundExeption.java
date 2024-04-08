package hiago.com.passin.domain.event.exceptions;

public class EventNotFoundExeption extends RuntimeException {
    public EventNotFoundExeption(String message){
        super(message);
    };
}
